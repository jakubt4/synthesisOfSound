package GUI;

import gui.components.Components;

import javax.swing.JFrame;

public class Frame extends JFrame {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private final WindowDimension dimension;
    private final Components components;
    private final boolean resizableOfWindow = false;

    public Frame(WindowDimension dimension) {
        this.dimension = dimension;
        components = new Components(this.getContentPane());
    }

    public void init() {
        this.setTitle("Synthesis Of Sound");
        this.setBounds(dimension.getX(), dimension.getY(),
                dimension.getWidth(), dimension.getHeight());
        this.setResizable(this.resizableOfWindow);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        components.init();
    }
}
