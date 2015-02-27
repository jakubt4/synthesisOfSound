package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

public class WindowDimension{

    Toolkit toolkit;
    Dimension dimension;

    public WindowDimension(){
        this.toolkit = Toolkit.getDefaultToolkit();
        this.dimension = this.toolkit.getScreenSize();
    }

    public int getDimensionX(){
        return this.dimension.width;
    }

    public int getDimensionY(){
        return this.dimension.height;
    }
}
