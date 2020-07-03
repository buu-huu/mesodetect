import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    JPanel mainPanel;
    InformationPanel informationPanel;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        informationPanel = new InformationPanel();

        mainPanel.add(informationPanel, BorderLayout.EAST);

        add(mainPanel);

        setSize(1100, 980);
        setTitle("Mesodetect");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
