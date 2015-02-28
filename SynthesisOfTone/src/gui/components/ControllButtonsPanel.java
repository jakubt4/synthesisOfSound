package gui.components;

import gui.components.util.ComponentsUtil;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ControllButtonsPanel extends JPanel implements InterfaceComponents {

    private static final long serialVersionUID = 1L;

    public final ArrayList<JComponent> components = new ArrayList<>();

    public ControllButtonsPanel() {
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        JButton start = ComponentsUtil.createButton("Start");
        ComponentsUtil.setBounds(start, 300, 0, 100, 50);
        components.add(start);

        JButton stop = ComponentsUtil.createButton("Stop");
        ComponentsUtil.setBounds(stop, 500, 0, 100, 50);
        components.add(stop);
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setBounds(this, 10, 550, 600, 100);
        ComponentsUtil.addComponentsToPanel(components, this);

        return this;
    }

}
