package gui.components;

import gui.components.util.ComponentsUtil;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class GraphPanel extends ChartPanel implements InterfaceComponents {

    private static final long serialVersionUID = 1L;

    public GraphPanel(JFreeChart chart) {
        super(chart);
    }

    @Override
    public void createComponentsForPanel() {
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setBounds(this, 10, 50, 800, 450);
        this.setBorder(BorderFactory.createBevelBorder(0));
        return this;
    }
}
