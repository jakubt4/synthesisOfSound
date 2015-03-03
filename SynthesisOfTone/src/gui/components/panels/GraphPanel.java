package gui.components.panels;

import gui.components.PartPanel;

import java.awt.Color;

import javax.swing.BorderFactory;
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
        this.setBounds(10, 50, 800, 450);
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setBackground(Color.WHITE);
        return this;
    }
}
