package gui.components.panels;

import gui.components.PartPanel;

import javax.swing.JPanel;
import javax.swing.JSlider;

public abstract class AbstractListenerSlider extends JPanel implements
        PartPanel {

    private static final long serialVersionUID = 1L;

    protected void addListener(final JSlider slider, final int i) {
    };
}
