import javax.swing.*;
import java.awt.*;

public class Menu extends JMenu {
    private Font font = new Font("Courier", Font.PLAIN, 14);
    private Color fg = new Color(200, 120, 150);

    public Menu(String s) {
        super(s);

        setForeground(fg);
        setFont(font);
    }
}
