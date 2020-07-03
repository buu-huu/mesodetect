import javax.swing.*;
import java.awt.*;

public class NavigationLabel extends JLabel {
    private Font font = new Font("Courier", Font.PLAIN, 12);
    private Color color = Color.BLACK;

    public NavigationLabel(String text) {
        super(text);

        setFont(font);
        setForeground(color);
    }
}
