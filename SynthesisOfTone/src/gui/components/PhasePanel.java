package gui.components;

import gui.components.util.ComponentsUtil;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import plotGraph.PlotGraph;

public class PhasePanel extends JPanel implements
        InterfaceWrapperElementComponents {

    private static final long serialVersionUID = 1L;
    private final ArrayList<JComponent> components = new ArrayList<>();
    private PanelSliders panelSliders;
    private PanelTextField panelTF;
    private final Components plot;
    private final PlotGraph plotGraph;

    public PhasePanel(Components plot, PlotGraph plotGraph) {
        this.plot = plot;
        // TODO Auto-generated constructor stub
        this.plotGraph = plotGraph;
    }

    @Override
    public void createComponentsForPanel() {
        panelTF = new PanelTextField(this);
        panelTF.createComponentsForPanel();
        ComponentsUtil.setBounds(panelTF, 1050, 50, 200, 600);
        components.add(panelSliders);

        panelSliders = new PanelSliders(panelTF, plot, plotGraph);
        panelSliders.createComponentsForPanel();
        ComponentsUtil.setBounds(panelSliders, 830, 50, 200, 600);
        components.add(panelSliders);
    }

    @Override
    public JPanel getPanel() {
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
