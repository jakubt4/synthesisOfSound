package gui.components.panels;

import gui.components.ComponentsUtil;
import gui.components.PartPanel;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllButtonsPanel extends JPanel implements PartPanel {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    public ControllButtonsPanel() {
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        JButton start = new JButton("Start");
        start.setBounds(0, 0, 100, 35);
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

}
