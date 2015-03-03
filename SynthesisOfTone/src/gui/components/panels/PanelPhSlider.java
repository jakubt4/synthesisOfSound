package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class PanelPhSlider extends AbstractListenerSlider {

    private static final long serialVersionUID = 1L;
    private final Components components;

    public PanelPhSlider(Components components) {
        this.components = components;
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < 7; i++) {
            JSlider slider = new JSlider();
            setupSl(slider);
            addListener(slider, i);
            this.add(slider);
        }
    }

    @Override
    protected void addListener(final JSlider sl, final int i) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                phases.get(i)
                        .setText(
                                String.valueOf(((double) sl.getValue() / 100)
                                        * Math.PI));

                ComponentsUtil.doAction(components);
            }
        });
    }

    private void setupSl(JSlider sl) {
        sl.setMaximum(200);
        sl.setMinorTickSpacing(20);
        sl.setPaintLabels(true);
        sl.setPaintTicks(true);
        sl.setValue(0);
        sl.setBackground(Color.WHITE);
    }

    @Override
    public JPanel getPanel() {
        this.setBounds(850, 300, 250, 229);
        this.setBorder(BorderFactory.createBevelBorder(0));
        this.setBackground(Color.WHITE);
        return this;
    }

}
