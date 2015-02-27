package GUI;

import java.awt.Color;

public class Window{

    private final Frame frame;
    private WindowDimension dimension;

    private int WIDTH;
    private int HEIGHT;
    private int X;
    private int Y;

    private final double constantForWindSize = 1.5;
    private final int constantForWindPlace = 6;

    private final boolean resizableOfWindow = false;

    public Window(){
        this.frame = new Frame();
    }

    public void init(){
        this.initDimension();
        this.initFrame();
    }

    private void initDimension(){
        this.dimension = new WindowDimension();
        this.WIDTH = (int) (this.dimension.getDimensionX() / this.constantForWindSize);
        this.HEIGHT = (int) (this.dimension.getDimensionY() / this.constantForWindSize);
        this.X = this.dimension.getDimensionX() / this.constantForWindPlace;
        this.Y = this.dimension.getDimensionY() / this.constantForWindPlace;
    }

    private void initFrame(){
        this.frame.setBackground(Color.BLACK);
        this.frame.setBounds(this.X, this.Y, this.WIDTH, this.HEIGHT);
        this.frame.setResizable(this.resizableOfWindow);
    }

    public void start(){
        this.frame.setVisible(true);
    }
}
