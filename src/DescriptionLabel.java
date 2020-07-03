import javax.swing.*;
import java.awt.*;

public class DescriptionLabel extends JLabel {
    private Font font = new Font("Courier", Font.PLAIN, 12);
    private Color color = Color.BLACK;
    private final boolean PLACE_COLON = true;

    public DescriptionLabel(String text) {
        super(text);
        if (PLACE_COLON) {
            String description = text;
            description += ":";
            setText(description);
        }

        setFont(font);
        setForeground(color);
    }
}
