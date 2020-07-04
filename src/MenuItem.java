import javax.swing.*;
import java.awt.*;

public class MenuItem extends JMenuItem {
    private Font font = new Font("Courier", Font.PLAIN, 14);
    private Color fg = new Color(200, 120, 150);
    private Color bg = new Color(40, 40, 40);

    public MenuItem(String s) {
        super(s);

        setBackground(bg);
        setForeground(fg);
        setFont(font);
    }
}
