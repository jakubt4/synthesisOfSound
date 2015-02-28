package GUI;

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
        Font font = ComponentsUtil.createFont("SansSerif", Font.BOLD, 20);
        jLabel.setFont(font);
        ComponentsUtil.setBounds(jLabel, 10, 5, 300, 30);

        components.add(jLabel);
    }

    @Override
    public Panel getPanel() {
        ComponentsUtil.setBounds(this, 10, 5, 300, 30);
        ComponentsUtil.addComponentsToPanel(components, this);
        return this;
    }

}
