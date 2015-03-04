package gui.components;

import gui.Frame;
import gui.components.panels.ControllButtonsPanel;
import gui.components.panels.FrekvPanel;
import gui.components.panels.GraphPanel;
import gui.components.panels.PanelAmpTextField;
import gui.components.panels.PanelAmplSlider;
import gui.components.panels.PanelPhSlider;
import gui.components.panels.PanelPhTextField;
import gui.components.panels.SettingButtonsPanel;
import gui.components.panels.Title;

import java.awt.Container;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JTextField;

import plotGraph.PlotGraph;

public class Components implements Elements {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private final Container container;

    private Title title;
    private GraphPanel graphPanel;
    private FrekvPanel frekvPanel;
    private PanelAmpTextField panelAmpTextField;
    private PanelAmplSlider panelAmplSlider;
    private PanelPhTextField panelPhTextField;
    private PanelPhSlider panelPhSlider;
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

        panelAmpTextField = new PanelAmpTextField();
        create(panelAmpTextField);
        panelAmplSlider = new PanelAmplSlider(this);
        create(panelAmplSlider);

        panelPhTextField = new PanelPhTextField();
        create(panelPhTextField);
        panelPhSlider = new PanelPhSlider(this);
        create(panelPhSlider);

        frekvPanel = new FrekvPanel(this);
        create(frekvPanel);
        setFrekv();

        plotGraph = new PlotGraph();
        plotGraph.setAll(getDoubles(ampls), getDoubles(phases), frekv.get(0));
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());
        create(graphPanel);

        settingButtonsPanel = new SettingButtonsPanel();
        create(settingButtonsPanel);

        controllPanel = new ControllButtonsPanel();
        create(controllPanel);

        LOG.info("Init of " + this.getClass().getSimpleName()
                + " was succesful.");
    }

    public double[] getDoubles(ArrayList<JTextField> values) {
        double[] doubles = new double[values.size()];
        int i = 0;
        for (JTextField value : values) {
            doubles[i] = Double.parseDouble(value.getText());
            i++;
        }
        return doubles;
    }

    public <T extends PartPanel> void create(T panel) {
        panel.createComponentsForPanel();
        try {
            if (container.add(panel.getPanel()) != null) {
                LOG.info("Adding " + panel.getClass().getSimpleName()
                        + " done.");
            }

        } catch (NullPointerException e) {
            LOG.warning("Failed to add " + panel.getClass().getSimpleName()
                    + " to container - " + e.toString());
        }
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

    public void setFrekv() {
        frekvPanel.setFrekv();
    }
}
