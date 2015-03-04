package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.PartPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrekvPanel extends JPanel implements PartPanel {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

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
        jTextField.setFont(font);
        this.add(jTextField);

        JButton jButton = new JButton("OK");
        jButton.setBounds(215, 10, 70, 30);

        addListener(jButton);
        this.add(jButton);

        LOG.info("Components added to panel");

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

        LOG.info("Added listener");
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 850, 550, 415, 60, true);
        return this;
    }

    public void setFrekv() {
        frekv.add(0, Integer.parseInt(jTextField.getText()));
    }

}
