import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapPanel extends JPanel {
    private MainWindow parentFrame;
    private BufferedImage backgroundMap;
    private Color bg = new Color(50, 50, 50);
    private MesocycloneTile mesocycloneTile;

    final static int PANEL_WIDTH = 800;
    final static int PANEL_HEIGHT = 955;

    public MapPanel(MainWindow parentFrame) throws IOException {
        this.parentFrame = parentFrame;
        setLayout(null);
        backgroundMap = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "res\\map_germany.png"));

        mesocycloneTile = new MesocycloneTile(4, 9.183333, 48.783333);
        add(mesocycloneTile);

        setBackground(bg);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundMap, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
