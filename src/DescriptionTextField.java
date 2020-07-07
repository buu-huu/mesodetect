import javax.swing.*;
import java.awt.*;

/**
 * Special JTextField normaly used to show values of mesocyclone object.
 * @author Luca Schwarz
 */
public class DescriptionTextField extends JTextField {
    private Color fg = Color.WHITE;
    private Color bg = Color.DARK_GRAY;

    public DescriptionTextField() {
        super();

        setPreferredSize(new Dimension(150, 20));
        setBorder(null);
        setEnabled(false);
        setBackground(bg);
        setDisabledTextColor(fg);
    }
}
