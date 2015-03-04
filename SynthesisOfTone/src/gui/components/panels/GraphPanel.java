package gui.components.panels;

import gui.components.ComponentsUtil;
import gui.components.PartPanel;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class GraphPanel extends ChartPanel implements PartPanel {

    private static final long serialVersionUID = 1L;

    public GraphPanel(JFreeChart chart) {
        super(chart);
    }

    @Override
    public void createComponentsForPanel() {
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 10, 50, 800, 450, true);
        return this;
    }
}
