package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllButtonsPanel extends JPanel implements PanelIntereface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    private Components components;

    public ControllButtonsPanel(Components components) {
        this.components = components;
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        JButton start = new JButton("Start");
        start.setBounds(0, 0, 100, 35);
        addListener(start);
        this.add(start);

        JButton stop = new JButton("Stop");
        stop.setBounds(150, 0, 100, 35);
        this.add(stop);

        LOG.info("Buttons added to panel.");
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 610, 530, 400, 35, false);
        return this;
    }
    
    private void addListener(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClicked(e);
            }

            private void mouseClicked(ActionEvent e) {
                
            }
        });

        LOG.info("Added listener");
    }

}
