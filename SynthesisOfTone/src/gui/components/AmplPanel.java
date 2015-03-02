package gui.components;

import gui.components.util.ComponentsUtil;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import plotGraph.PlotGraph;

public class AmplPanel extends JPanel implements
        InterfaceWrapperElementComponents {

    private static final long serialVersionUID = 1L;
    private final ArrayList<JComponent> components = new ArrayList<>();
    private PanelSliders panelSliders;
    private PanelTextField panelTF;
    private final Components plot;
    private final PlotGraph plotGraph;

    public AmplPanel(Components plot, PlotGraph plotGraph) {
        this.plot = plot;
        // TODO Auto-generated constructor stub
        this.plotGraph = plotGraph;
    }

    @Override
    public void createComponentsForPanel() {
        panelTF = new PanelTextField(this);
        panelTF.createComponentsForPanel();
        ComponentsUtil.setBounds(panelTF, 250, 0, 200, 600);
        components.add(panelTF.getPanel());

        panelSliders = new PanelSliders(panelTF, plot, plotGraph);
        panelSliders.createComponentsForPanel();
        ComponentsUtil.setBounds(panelSliders, 0, 0, 200, 600);
        components.add(panelSliders.getPanel());
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setBounds(this, 830, 50, 500, 600);
        ComponentsUtil.addComponentsToPanel(components, this);
        return this;
    }

    @Override
    public double[] getElements(PanelTextField panelTF) {
        return panelTF.getElements(panelTF);
    }

    @Override
    public PanelTextField getPanelTextField() {
        return panelTF;
    }
}
