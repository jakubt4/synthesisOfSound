package gui.components.panels;

import gui.components.PartPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title extends JPanel implements PartPanel {

    private static final long serialVersionUID = 1L;

    private JLabel jLabel;

    public Title() {
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        jLabel = new JLabel("Synthesis Of Tone");
        Font font = new Font("Serif", Font.BOLD, 20);
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(font);
        jLabel.setBounds(10, 5, 300, 40);

        this.add(jLabel);
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(10, 5, 300, 40);
        this.setBackground(Color.LIGHT_GRAY);
        return this;
    }

}
