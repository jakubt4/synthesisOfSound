package gui.components;

import gui.components.util.ComponentsUtil;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title extends JPanel implements InterfaceComponents {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JLabel jLabel;

    private final ArrayList<JComponent> components = new ArrayList<>();

    public Title() {
        this.setLayout(null);
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
    public JPanel getPanel() {
        ComponentsUtil.setBounds(this, 10, 5, 300, 40);
        ComponentsUtil.addComponentsToPanel(components, this);
        return this;
    }

}
