package gui.components;

import gui.components.util.ComponentsUtil;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelTextField extends JPanel implements
        InterfaceElementComponents {

    private static final long serialVersionUID = 1L;
    private final JPanel panel;

    public PanelTextField(JPanel panel) {
        this.panel = panel;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void createComponentsForPanel() {
        if (panel instanceof AmplPanel) {
            ComponentsUtil.createArrayOfFields(ampls);
        } else {
            ComponentsUtil.createArrayOfFields(phases);
        }
    }

    @Override
    public JPanel getPanel() {
        if (panel instanceof AmplPanel) {
            ComponentsUtil.addComponentsToPanel(ampls, this);
        } else {
            ComponentsUtil.addComponentsToPanel(phases, this);
        }
        return this;
    }

    @Override
    public double[] getElements(PanelTextField panelTF) {
        if (panel instanceof AmplPanel) {
            return ComponentsUtil.getVaulesFromComp(ampls);
        } else {
            return ComponentsUtil.getVaulesFromComp(phases);
        }
    }

    public ArrayList<JComponent> getArrayListTF() {
        if (panel instanceof AmplPanel) {
            return ampls;
        } else {
            return phases;
        }
    }
}
