package gui.components.panels;

import gui.components.PartPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllButtonsPanel extends JPanel implements PartPanel {

    private static final long serialVersionUID = 1L;

    public ControllButtonsPanel() {
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        JButton start = new JButton("Start");
        start.setBounds(300, 0, 100, 50);
        this.add(start);

        JButton stop = new JButton("Stop");
        stop.setBounds(500, 0, 100, 50);
        this.add(stop);
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(10, 550, 600, 100);
        this.setBackground(Color.LIGHT_GRAY);
        return this;
    }

}
