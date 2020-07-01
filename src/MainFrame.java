import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Container mainContainer;
    JLayeredPane mapLayer;
    BackgroundMap bgMap;
    Mesocyclone meso1;

    public MainFrame() {
        initUI();
    }

    private void initUI() {
        mainContainer = getContentPane();
        mainContainer.setLayout(new FlowLayout(FlowLayout.LEFT));

        bgMap = new BackgroundMap();
        meso1 = new Mesocyclone();

        bgMap.add(meso1);

        mainContainer.add(bgMap);

        setSize(900, 1000);
        setTitle("Mesodetect | v1.0  \u00A9 ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
