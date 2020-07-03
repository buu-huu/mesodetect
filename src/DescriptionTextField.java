import javax.swing.*;
import java.awt.*;

public class DescriptionTextField extends JTextField {
    private Color fg = Color.WHITE;
    private Color bg = Color.DARK_GRAY;

    public DescriptionTextField() {
        super("Test 1....");

        setBorder(null);
        setEnabled(false);
        setBackground(bg);
        setDisabledTextColor(fg);
    }
}
