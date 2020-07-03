import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoNavigationPanel extends JPanel {
    private StandardButton leftButton, rightButton;
    private NavigationLabel navigationLabel;
    private TitledBorder border = new TitledBorder("MESO NAVIGATION");
    private Color bg = Color.GRAY;
    private Font font = new Font("Consolas", Font.BOLD, 30);

    public InfoNavigationPanel() {
        border.setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(new FlowLayout());
        setBorder(border);
        setBackground(bg);

        leftButton = new StandardButton("<");
        rightButton = new StandardButton(">");
        leftButton.setFont(font);
        rightButton.setFont(font);
        leftButton.setPreferredSize(new Dimension(50, 50));
        rightButton.setPreferredSize(new Dimension(50, 50));

        navigationLabel = new NavigationLabel("MESO 1 of 1");

        add(leftButton);
        add(navigationLabel);
        add(rightButton);
    }
}
