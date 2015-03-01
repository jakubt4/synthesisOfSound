package gui.components;

import javax.swing.JPanel;

public class PhasePanel extends JPanel implements InterfaceElementComponents {

    private static final long serialVersionUID = 1L;
    private final double[] phases = { 0, 0.5 };

    @Override
    public void createComponentsForPanel() {
        // TODO Auto-generated method stub

    }

    @Override
    public JPanel getPanel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double[] getElements() {
        // TODO Auto-generated method stub
        return phases;
    }

}
