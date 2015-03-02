package gui.components;

import gui.Frame;

import java.awt.Container;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JComponent;

import plotGraph.PlotGraph;

public class Components implements InterfaceForAmplsPhases {

    Logger LOG = Logger.getLogger("Components");

    private final Container container;

    private Title title;
    private GraphPanel graphPanel;
    private AmplPanel amplPanel;
    private PhasePanel phasePanel;
    private FrekvPanel frekvPanel;

    private PlotGraph plotGraph;

    private SettingButtonsPanel settingButtonsPanel;
    private ControllButtonsPanel controllPanel;

    private Frame frame;

    public Components(Container container) {
        this.container = container;
        container.setLayout(null);
    }

    public void init(Frame frame) {
        this.frame = frame;
        title = new Title();
        create(title);

        plotGraph = new PlotGraph();

        amplPanel = new AmplPanel(this, plotGraph);
        create(amplPanel);

        phasePanel = new PhasePanel(this, plotGraph);
        create(phasePanel);

        frekvPanel = new FrekvPanel(this);
        create(frekvPanel);

        plotGraph.setAll(amplPanel.getElements(amplPanel.getPanelTextField()),
                phasePanel.getElements(amplPanel.getPanelTextField()),
                frekvPanel.getElement());
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());
        create(graphPanel);

        settingButtonsPanel = new SettingButtonsPanel();
        create(settingButtonsPanel);

        controllPanel = new ControllButtonsPanel();
        create(controllPanel);
    }

    public <T extends InterfaceComponents> void create(T panel) {
        panel.createComponentsForPanel();
        try {
            container.add(panel.getPanel());
        } catch (NullPointerException e) {
            LOG.warning("Failed to add " + panel.getClass().getSimpleName()
                    + " to container - " + e.toString());
        }
    }

    public ArrayList<JComponent> getAmpls() {
        return ampls;
    }

    public ArrayList<JComponent> getPhases() {
        return phases;
    }

    public int getFrekv() {
        return frekv;
    }

    public Frame getFrame() {
        return frame;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }

    public void setGraphPanel(GraphPanel graphPanel2) {
        graphPanel = graphPanel2;
    }
}
