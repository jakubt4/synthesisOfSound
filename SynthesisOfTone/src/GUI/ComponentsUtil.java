package GUI;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ComponentsUtil {

    private ComponentsUtil() {
        // TODO Auto-generated constructor stub
    }

    public static JLabel creatLabel(String string) {
        // TODO Auto-generated method stub
        return new JLabel(string);
    }

    public static void addComponentsToPanel(
            ArrayList<JComponent> componentsInPanel, Panel panel) {
        for (JComponent component : componentsInPanel) {
            panel.add(component);
        }
    }

    public static Font createFont(String name, int style, int size) {
        // TODO Auto-generated method stub
        return new Font(name, style, size);
    }

    public static <T extends JComponent> void setBounds(T component, int x,
            int y, int width, int height) {
        // TODO Auto-generated method stub
        component.setBounds(x, y, width, height);
    }

}
