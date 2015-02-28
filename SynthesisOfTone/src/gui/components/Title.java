package gui.components;

import gui.Panel;
import gui.components.util.ComponentsUtil;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Title extends Panel implements CreateComponents {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JLabel jLabel;

    private final ArrayList<JComponent> components;

    public Title() {
        this.setLayout(null);
        components = new ArrayList<>();
    }

    @Override
    public void createComponentsForPanel() {
        jLabel = ComponentsUtil.creatLabel("Synthesis Of Tone");
        Font font = ComponentsUtil.createFont("Serif", Font.BOLD, 20);
        jLabel.setFont(font);
        ComponentsUtil.setBounds(jLabel, 10, 5, 300, 40);

        components.add(jLabel);
    }

    @Override
    public Panel getPanel() {
        ComponentsUtil.setBounds(this, 10, 5, 300, 40);
        ComponentsUtil.addComponentsToPanel(components, this);
        return this;
    }

}
