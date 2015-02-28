package test.gui;

import gui.Window;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WindowTest {

    private Window window;

    @Before
    public void setUp() {
        window = new Window();
    }

    @Test
    public void WindowNullTest() {
        Assert.assertNotNull(window);
    }
}
