package gui.components;

import gui.components.panels.PanelAmpTextField;
import gui.components.panels.PanelAmplSlider;
import gui.components.panels.PanelPhSlider;
import gui.components.panels.PanelPhTextField;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AmplPhasesSetUpFrame extends JFrame implements Elements {

    private static final long serialVersionUID = 1L;

    private PanelAmpTextField panelAmpTextField;
    private PanelAmplSlider panelAmplSlider;
    private final Components components;
    private final Container container;

    private PanelPhSlider panelPhSlider;

    private PanelPhTextField panelPhTextField;

    private JLabel label;

    public AmplPhasesSetUpFrame(Components components) {
        this.components = components;
        container = this.getContentPane();
        container.setLayout(null);
    }

    public void init() {
        this.setTitle("Amplitudes and phases");

        label = new JLabel("Amplitudes");
        label.setBounds(10, 10, 80, 30);
        container.add(label);

        panelAmpTextField = new PanelAmpTextField();
        panelAmpTextField.createComponentsForPanel();
        panelAmplSlider = new PanelAmplSlider(components);
        panelAmplSlider.createComponentsForPanel();

        panelPhTextField = new PanelPhTextField();
        panelPhTextField.createComponentsForPanel();
        panelPhSlider = new PanelPhSlider(components);
        panelPhSlider.createComponentsForPanel();
    }

    public void createComponentsForFrame() {
        this.setSize(800, (panelAmplSlider.getPanel().getHeight()) + 10);

        container.add(panelAmplSlider.getPanel());
        container.add(panelAmpTextField.getPanel());

        container.add(panelPhSlider.getPanel());
        container.add(panelPhTextField.getPanel());

        this.setVisible(true);

        frames.add(this);
    }
}
