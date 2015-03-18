package gui.components.frame;

import gui.components.Components;
import gui.components.ElementsListener;
import gui.components.frame.panels.LabelPanel;
import gui.components.frame.panels.PanelAmpTextField;
import gui.components.frame.panels.PanelAmplSlider;
import gui.components.frame.panels.PanelPhSlider;
import gui.components.frame.panels.PanelPhTextField;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AmplPhasesSetUpFrame extends JFrame implements ElementsListener, FrameListener {

    private static final long serialVersionUID = 1L;

    private PanelAmpTextField panelAmpTextField;
    private PanelAmplSlider panelAmplSlider;
    private final Components components;
    private final Container container;

    private PanelPhSlider panelPhSlider;

    private PanelPhTextField panelPhTextField;

    private JLabel label;

    private LabelPanel labelPanel;

    public AmplPhasesSetUpFrame(Components components) {
        this.components = components;
        container = this.getContentPane();
        container.setLayout(null);
    }

    public void init() {
        this.setTitle("Amplitudes and phases");

        label = new JLabel("Amplitudes");
        label.setBounds(110, 10, 80, 30);
        container.add(label);

        labelPanel = new LabelPanel(20);
        labelPanel.createComponentsForPanel();
        container.add(labelPanel.getPanel());

        panelAmpTextField = new PanelAmpTextField();
        panelAmpTextField.createComponentsForPanel();
        panelAmplSlider = new PanelAmplSlider(components);
        panelAmplSlider.createComponentsForPanel();

        label = new JLabel("Phases");
        label.setBounds(450, 10, 80, 30);
        container.add(label);

        labelPanel = new LabelPanel(360);
        labelPanel.createComponentsForPanel();
        container.add(labelPanel.getPanel());

        panelPhTextField = new PanelPhTextField();
        panelPhTextField.createComponentsForPanel();
        panelPhSlider = new PanelPhSlider(components);
        panelPhSlider.createComponentsForPanel();
        amplPhasesSetUpFrames.add(this);
    }

    public void createComponentsForFrame() {
        this.setSize(690, (panelAmplSlider.getPanel().getHeight()) + 10);

        container.add(panelAmplSlider.getPanel());
        container.add(panelAmpTextField.getPanel());

        container.add(panelPhSlider.getPanel());
        container.add(panelPhTextField.getPanel());

        this.setVisible(true);
        this.setResizable(false);

        frames.add(this);
    }
}