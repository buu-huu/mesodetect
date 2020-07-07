import javax.swing.*;
import java.awt.*;

/**
 * Special JLabel normaly used to describe values next to a TextField.
 * @author Luca Schwarz
 */
public class DescriptionLabel extends JLabel {
    private Font font = new Font("Courier", Font.PLAIN, 12);
    private Color color = Color.BLACK;
    private final boolean PLACE_COLON = true;

    /**
     * @param text text to be showed on label
     */
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
