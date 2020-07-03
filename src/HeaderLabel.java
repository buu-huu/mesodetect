import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel {
    Font font = new Font("Courier", Font.ITALIC, 20);
    Color color = Color.BLACK;

    public HeaderLabel(String text) {
        super(text);

        setFont(font);
        setForeground(color);
    }
}
