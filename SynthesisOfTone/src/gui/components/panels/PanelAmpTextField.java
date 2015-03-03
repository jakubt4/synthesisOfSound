package gui.components.panels;

import gui.components.PartPanel;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAmpTextField extends JPanel implements PartPanel {

    private static final long serialVersionUID = 1L;

    public PanelAmpTextField() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < 7; i++) {
            JTextField tf = new JTextField();
            tf.setText("0.0");
            tf.setEditable(false);
            this.add(tf);
            ampls.add(tf);
        }
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(1110, 53, 40, 230);
        this.setBackground(Color.LIGHT_GRAY);
        return this;
    }
}
