package gui.components.util;

import gui.components.Components;
import gui.components.GraphPanel;
import gui.components.PanelTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import plotGraph.PlotGraph;

public class ComponentsUtil {

    private ComponentsUtil() {
        // TODO Auto-generated constructor stub
    }

    public static JLabel creatLabel(String string) {
        // TODO Auto-generated method stub
        return new JLabel(string);
    }

    public static void addComponentsToPanel(
            ArrayList<JComponent> componentsInPanel, JPanel panel) {
        int i = 0;
        for (JComponent component : componentsInPanel) {
            if (component instanceof JTextField && componentsInPanel.size() > 1) {
                if (i == 0) {
                    panel.add(component);
                    i++;
                } else {
                    panel.add(Box.createRigidArea(new Dimension(10, 13)));
                    panel.add(component);
                }
            } else {
                if (i == 0 && component instanceof JSlider) {
                    panel.add(Box.createRigidArea(new Dimension(10, 15)));
                    i++;
                }
                panel.add(component);
                panel.add(Box.createRigidArea(new Dimension(10, 5)));
            }
        }
    }

    public static Font createFont(String name, int style, int size) {
        // TODO Auto-generated method stub
        return new Font(name, style, size);
    }

    public static <T extends JComponent> void setBounds(T component, int x,
            int y, int width, int height) {
        // TODO Auto-generated method stub
        component.setBounds(x, y, width, height);
    }

    public static JButton createButton(String string) {
        // TODO Auto-generated method stub
        return new JButton(string);
    }

    public static ArrayList<JComponent> createArrayOfSlider(int count,
            PanelTextField panelTF, Components plot, PlotGraph plotGraph) {
        ArrayList<JComponent> arrayListS = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            JSlider slider = new JSlider();
            setupSlider(slider);
            addListener(slider, panelTF, i, plot, plotGraph);
            arrayListS.add(slider);
        }
        return arrayListS;
    }

    private static void addListener(final JSlider slider,
            final PanelTextField panelTF, final int i, final Components plot,
            final PlotGraph plotGraph) {
        slider.addMouseMotionListener(new MouseMotionAdapter() {

            private GraphPanel graphPanel;

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                JTextField textField = (JTextField) panelTF.getArrayListTF()
                        .get(i);
                textField.setText(String.valueOf((double) slider.getValue() / 100));

                plot.getFrame().remove(plot.getGraphPanel());
                plot.getFrame().repaint();

                double[] test = new double[7];

                for (int j = 0; j < 7; j++) {
                    // System.out.println(test[i]);
                    JTextField bla = (JTextField) panelTF.getArrayListTF().get(
                            j);
                    System.out.println(bla.getText());

                    test[j] = Double.parseDouble(bla.getText());
                }

                System.out.println("-------");

                plotGraph.setAll(test,
                        ComponentsUtil.getVaulesFromComp(plot.getPhases()),
                        plot.getFrekv());

                double[] testAmpls = plotGraph.getAmpls();

                System.out.println(testAmpls[i]);

                System.out.println("-------");

                plotGraph.init();

                plot.getFrame().remove(plot.getGraphPanel());
                plot.getFrame().repaint();

                graphPanel = new GraphPanel(plotGraph.createChart());

                plot.getFrame().add(graphPanel.getPanel());
                plot.getFrame().repaint();
                plot.setGraphPanel(graphPanel);
                System.out.println("som tu");
            }
        });
    }

    private static void setupSlider(JSlider slider) {
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValue(0);
    }

    public static double[] getVaulesFromComp(ArrayList<JComponent> components) {
        int sizeOfArray = components.size();
        double[] values = new double[sizeOfArray];
        int i = 0;
        for (JComponent component : components) {
            JTextField tf = (JTextField) component;
            values[i] = Double.parseDouble(tf.getText());
        }

        return values;
    }

    public static void createArrayOfFields(ArrayList<JComponent> ampls) {
        for (int i = 0; i < 7; i++) {
            JTextField textField = new JTextField();
            textField.setText("0.0");
            textField.setEditable(false);
            ampls.add(textField);
        }
    }

}
