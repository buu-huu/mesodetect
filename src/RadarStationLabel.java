import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RadarStationLabel extends JLabel {
    Color bgStandard = Color.WHITE;
    Color bgUp = Color.GREEN;
    Color bgNotUp = Color.RED;
    Color fg = Color.BLACK;
    Border border = BorderFactory.createBevelBorder(0);

    public RadarStationLabel(String text) {
        super(text);

        setHorizontalTextPosition(JLabel.CENTER);
        setBorder(border);
        setOpaque(true);
        setForeground(fg);
        setBackground(bgStandard);
    }

    public void setActive() {
        setBackground(bgUp);
    }

    public void setNotUp() {
        setBackground(bgNotUp);
    }

}
