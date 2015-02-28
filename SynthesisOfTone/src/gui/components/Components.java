package gui.components;

import java.awt.Container;
import java.util.logging.Logger;

import org.jfree.chart.JFreeChart;

import plotGraph.PlotGraph;

public class Components {

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

    private JFreeChart chart;

    public Components(Container container) {
        this.container = container;
        container.setLayout(null);
    }

    public void init() {
        title = new Title();
        create(title);

        amplPanel = new AmplPanel();
        create(amplPanel);

        phasePanel = new PhasePanel();
        create(phasePanel);

        frekvPanel = new FrekvPanel();
        create(frekvPanel);

        plotGraph = new PlotGraph(amplPanel.getElements(),
                phasePanel.getElements(), frekvPanel.getElement());
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());
        create(graphPanel);

        settingButtonsPanel = new SettingButtonsPanel();
        create(settingButtonsPanel);

        controllPanel = new ControllButtonsPanel();
        create(controllPanel);
    }

    private <T extends InterfaceComponents> void create(T panel) {
        panel.createComponentsForPanel();
        try {
            container.add(panel.getPanel());
        } catch (NullPointerException e) {
            LOG.warning("Failed to add " + panel.getClass().getSimpleName()
                    + " to container - " + e.toString());
        }
    }
}
