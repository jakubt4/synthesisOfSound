package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;
import gui.components.frame.AmplPhasesSetUpFrame;
import gui.components.frame.FrameListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TitleAndSetForNumberOfElements extends JPanel implements
        PanelIntereface, FrameListener {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;

    private final Components components;

    public TitleAndSetForNumberOfElements(Components components) {
        this.components = components;
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        jLabel = new JLabel("Synthesis Of Tone");
        Font font = new Font("Serif", Font.BOLD, 20);
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(font);
        jLabel.setBounds(10, 5, 300, 40);

        this.add(jLabel);

        jLabel = new JLabel("Number of elements:");
        jLabel.setBounds(535, 5, 200, 40);
        this.add(jLabel);

        jTextField = new JTextField("7");
        jTextField.setBounds(690, 13, 30, 25);
        this.add(jTextField);

        jButton = new JButton("OK");
        font = new Font("Serif", Font.PLAIN, 10);
        jButton.setFont(font);
        jButton.setBounds(740, 12, 55, 26);
        addListener(jButton);
        this.add(jButton);

        LOG.info("Added " + jLabel.getClass().getSimpleName() + " to panel.");
    }

    private void addListener(JButton button) {
        button.addActionListener(new ActionListener() {

            private AmplPhasesSetUpFrame amplFrame;

            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClicked(e);
            }

            private void mouseClicked(ActionEvent e) {
                if (frames.size() != 0) {
                    Point location = amplPhasesSetUpFrames.get(0).getLocation();
                    for (int i = 0; i < frames.size(); i++) {
                        frames.get(i).dispose();
                    }

                    ampls.removeAll(ampls);
                    phases.removeAll(phases);

                    NUMBER_OF_ELEMENTS.add(0,
                            Integer.parseInt(jTextField.getText()));

                    amplFrame = new AmplPhasesSetUpFrame(components);
                    amplFrame.init();
                    amplFrame.createComponentsForFrame();
                    amplFrame.setLocation(location);

                    ComponentsUtil.doAction(components);
                }
            }
        });

        LOG.info("Added listener");
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(60, 5, 800, 40);
        return this;
    }

}
