import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StandardButton extends JButton {
    Font font = new Font("Courier", Font.PLAIN, 12);
    Color fg = Color.YELLOW;
    Color bg = Color.DARK_GRAY;
    Border border = BorderFactory.createBevelBorder(0);
    Dimension size = new Dimension(120, 35);

    public StandardButton(String text) {
        super(text);

        setPreferredSize(size);
        setBorder(border);
        setFont(font);
        setForeground(fg);
        setBackground(bg);
    }
}
