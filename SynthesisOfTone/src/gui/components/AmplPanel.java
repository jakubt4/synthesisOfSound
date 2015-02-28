package gui.components;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AmplPanel extends JPanel implements InterfaceElementComponents {

    private static final long serialVersionUID = 1L;
    private final double[] ampls = { 0 };
    private final ArrayList<JComponent> components = new ArrayList<>();

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
        return ampls;
    }

}
