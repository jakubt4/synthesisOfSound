package GUI;

public class Window {

    private final Frame frame;
    private final WindowDimension dimension;

    public Window() {
        dimension = new WindowDimension();
        this.frame = new Frame(dimension);
    }

    public void init() {
        dimension.init();
        frame.init();
    }

    public void start() {
        frame.setVisible(true);
    }
}
