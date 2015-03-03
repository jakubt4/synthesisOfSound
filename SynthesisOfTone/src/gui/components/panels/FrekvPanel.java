package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.PartPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrekvPanel extends JPanel implements PartPanel {

    private static final long serialVersionUID = 1L;
    private JTextField jTextField;
    private final Components components;

    public FrekvPanel(Components components) {
        this.components = components;
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        JLabel jLabel = new JLabel("Frekvency");
        jLabel.setBounds(30, 0, 80, 50);
        this.add(jLabel);

        Font font = new Font("Serif", Font.BOLD, 12);

        jTextField = new JTextField("0");
        jTextField.setBounds(110, 11, 60, 30);
        jTextField.setBackground(Color.LIGHT_GRAY);
        jTextField.setFont(font);
        this.add(jTextField);

        JButton jButton = new JButton("OK");
        jButton.setBounds(215, 10, 70, 30);

        addListener(jButton);
        this.add(jButton);

    }

    private void addListener(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouseClicked(e);
            }

            private void mouseClicked(ActionEvent e) {
                ComponentsUtil.doAction(components);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(850, 550, 400, 60);
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setBackground(Color.WHITE);
        return this;
    }

    public void setFrekv() {
        frekv.add(0, Integer.parseInt(jTextField.getText()));
    }

}
