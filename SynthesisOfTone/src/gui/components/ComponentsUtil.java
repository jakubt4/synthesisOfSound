package gui.components;

import gui.components.panels.GraphPanel;
import plotGraph.PlotGraph;

public class ComponentsUtil implements Elements {

    private static PlotGraph plotGraph;
    private static GraphPanel graphPanel;

    private ComponentsUtil() {

    }

    public static void doAction(Components components) {
        components.getFrame().remove(components.getGraphPanel());
        components.getFrame().repaint();

        components.setFrekv();

        plotGraph = new PlotGraph();
        plotGraph.setAll(components.getDoubles(ampls),
                components.getDoubles(phases), frekv.get(0));
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());

        components.getFrame().add(graphPanel.getPanel());
        components.getFrame().repaint();
        components.setGraphPanel(graphPanel);
    }
}
