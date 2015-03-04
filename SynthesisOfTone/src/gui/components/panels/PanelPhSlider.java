package gui.components.panels;

import gui.components.AbstractListenerSlider;
import gui.components.Components;
import gui.components.ComponentsUtil;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class PanelPhSlider extends AbstractListenerSlider {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;
    private final Components components;

    public PanelPhSlider(Components components) {
        this.components = components;
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < 7; i++) {
            JSlider slider = new JSlider();
            ComponentsUtil.setupSl(slider, 20, 200);
            addListener(slider, i);
            this.add(slider);
            LOG.info("Added " + slider.getClass().getSimpleName()
                    + " to panel.");
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
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {
                    phases.get(i).setText(
                            String.valueOf(((double) sl.getValue() / 100)
                                    * Math.PI));

                    ComponentsUtil.doAction(components);
                }
            }
        });
        LOG.info("Added listener.");
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 850, 300, 250, 229, true);
        return this;
    }

}
