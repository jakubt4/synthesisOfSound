package gui.components.frame;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.ElementsChangesListener;
import gui.components.frame.panels.LabelPanel;
import gui.components.frame.panels.PanelAmpTextField;
import gui.components.frame.panels.PanelAmplSlider;
import gui.components.frame.panels.PanelPhSlider;
import gui.components.frame.panels.PanelPhTextField;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class AmplPhasesSetUpFrame extends JFrame implements ElementsChangesListener, FrameListener {

    private static final long serialVersionUID = 1L;

    private PanelAmpTextField panelAmpTextField;
    private PanelAmplSlider panelAmplSlider;
    private final Components components;
    // private final Container container;

    private PanelPhSlider panelPhSlider;

    private PanelPhTextField panelPhTextField;

    private JLabel label;
    
    private final Point startLoc = null;

    private LabelPanel labelPanel;

    private final JPanel mainPanel;

    public AmplPhasesSetUpFrame(Components components) {
        this.components = components;
        // container = this.getContentPane();
        // container.setLayout(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
    }

    public void init() {
        this.setTitle("Amplitudes and phases");

        // label = new JLabel("Amplitudes");
        // label.setBounds(110, 10, 80, 30);
        // container.add(label);
        //
        // labelPanel = new LabelPanel(20);
        // labelPanel.createComponentsForPanel();
        // container.add(labelPanel.getPanel());
        //
        // panelAmpTextField = new PanelAmpTextField();
        // panelAmpTextField.createComponentsForPanel();
        // panelAmplSlider = new PanelAmplSlider(components);
        // panelAmplSlider.createComponentsForPanel();
        //
        // label = new JLabel("Phases");
        // label.setBounds(450, 10, 80, 30);
        // container.add(label);
        //
        // labelPanel = new LabelPanel(360);
        // labelPanel.createComponentsForPanel();
        // container.add(labelPanel.getPanel());
        //
        // panelPhTextField = new PanelPhTextField();
        // panelPhTextField.createComponentsForPanel();
        // panelPhSlider = new PanelPhSlider(components);
        // panelPhSlider.createComponentsForPanel();
        // amplPhasesSetUpFrames.add(this);
        JTextField tf;
        JSlider slider;
        JPanel panel;
        JLabel label;
        mainPanel.setPreferredSize(new Dimension(650, (NUMBER_OF_ELEMENTS.get(0) + 1) * 37));
        
        panel = new JPanel(null);
        panel.setSize(650, 37);
        label = new JLabel("Amplitudes");
        label.setBounds(50, 1, 200, 35);
        panel.add(label);

        label = new JLabel("Phases");
        label.setBounds(350, 1, 200, 35);
        panel.add(label);

        panel.setBounds(0, 0, 650, 37);
        mainPanel.add(panel);
        
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            panel = new JPanel(null);
            panel.setSize(650, 37);

            // label
            label = new JLabel(String.valueOf(i + 1) + ".");
            label.setBounds(15, 1, 30, 20);
            panel.add(label);

            // slider ampl
            slider = new JSlider();
            ComponentsUtil.setupSl(slider, 10, 100);
            slider.setBounds(50, 1, 200, 35);
            addListenerAmpl(slider, i);
            panel.add(slider);
            amplsSliders.add(slider);

            // tf ampl
            tf = new JTextField();
            tf.setText("0.0");
            tf.setEditable(false);
            tf.setBounds(255, 1, 50, 25);
            panel.add(tf);
            ampls.add(tf);

            label = new JLabel(String.valueOf(i + 1) + ".");
            label.setBounds(350, 1, 30, 20);
            panel.add(label);

            // slider ph
            slider = new JSlider();
            ComponentsUtil.setupSl(slider, 20, 200);
            slider.setBounds(385, 1, 200, 35);
            addListener(slider, i);
            panel.add(slider);
            phasesSliders.add(slider);

            // tf ph
            tf = new JTextField();
            tf.setText("0.0");
            tf.setEditable(false);
            tf.setBounds(590, 1, 50, 25);
            panel.add(tf);
            phases.add(tf);

            panel.setBounds(0, (i + 1) * 37, 700, 37);

            mainPanel.add(panel);
        }
    }

    protected void addListener(final JSlider sl, final int i) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {

                    String value = String.format("%.4g%n", ((double) sl.getValue() / 100) * Math.PI);

                    if (value.charAt(1) == ',') {
                        value = value.replace(',', '.');
                    }
                    phases.get(i).setText(value);
                    ComponentsUtil.doAction(components);
                }
            }
        });

        sl.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                setAction(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setAction(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                setAction(e);
            }

            private void setAction(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 200) {
                    String value = String.format("%.4g%n", ((double) sl.getValue() / 100) * Math.PI);
                    phases.get(i).setText(value);
                    ComponentsUtil.doAction(components);
                }
            }
        });
    }

    protected void addListenerAmpl(final JSlider sl, final int i) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {
                    ampls.get(i).setText(String.valueOf((double) sl.getValue() / 100));
                    ComponentsUtil.doAction(components);
                }
            }

        });

        sl.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                setAction(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setAction(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                setAction(e);
            }

            private void setAction(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 100) {
                    ampls.get(i).setText(String.valueOf((double) sl.getValue() / 100));
                    ComponentsUtil.doAction(components);
                }
            }
        });
    }

    public void createComponentsForFrame() {
//        this.setSize(700, (panelAmplSlider.getPanel().getHeight()) + 10);
        this.setSize(660, 320);

        // container.add(panelAmplSlider.getPanel());
        // container.add(panelAmpTextField.getPanel());
        //
        // container.add(panelPhSlider.getPanel());
        // container.add(panelPhTextField.getPanel());

        amplPhasesSetUpFrames.add(this);

        // set up scroller
        JScrollPane scrollFrame = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(660, 320));
        scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollFrame);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        frames.add(this);
    }
}
