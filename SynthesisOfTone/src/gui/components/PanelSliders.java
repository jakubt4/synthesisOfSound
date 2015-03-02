package gui.components;

import gui.components.util.ComponentsUtil;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import plotGraph.PlotGraph;

public class PanelSliders extends JPanel implements InterfaceComponents {

    private static final long serialVersionUID = 1L;
    private ArrayList<JComponent> components;
    private final PanelTextField panelTF;
    private final Components plot;
    private final PlotGraph plotGraph;

    public PanelSliders(PanelTextField panelTF, Components plot,
            PlotGraph plotGraph) {
        this.plot = plot;
        this.plotGraph = plotGraph;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.panelTF = panelTF;
    }

    @Override
    public void createComponentsForPanel() {
        components = ComponentsUtil.createArrayOfSlider(7, panelTF, plot,
                plotGraph);
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.addComponentsToPanel(components, this);
        return this;
    }

    public ArrayList<JComponent> getSliders() {
        return components;
    }
}
