import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Container mainContainer;

    public MainFrame() {
        initUI();
    }

    private void initUI() {
        setSize(900, 1000);
        setTitle("Mesodetect | v1.0  \u00A9 Luca Schwarz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
