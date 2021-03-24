import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapPanel extends JPanel {
    private MainFrame parentFrame;
    private BufferedImage backgroundMap;
    private Color bg = new Color(50, 50, 50);
    private Mesocyclone[] mesocyclones;
    private List<MesocycloneTile> mesocycloneTileList;

    final static int PANEL_WIDTH = 800;
    final static int PANEL_HEIGHT = 955;

    public MapPanel(MainFrame parentFrame) throws IOException {
        this.parentFrame = parentFrame;

        setLayout(null);
        backgroundMap = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "map_germany.png"));

        setBackground(bg);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundMap, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void loadMesocyclonesToMap() {
        if (parentFrame.getMesocyclones() != null) {
            this.mesocyclones = parentFrame.getMesocyclones();
            this.mesocycloneTileList = new ArrayList<>();

            for (Mesocyclone meso : mesocyclones) {
                try {
                    mesocycloneTileList.add(new MesocycloneTile(meso.getIntensity(), meso.getLongitude(), meso.getLatitude()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Iterator<MesocycloneTile> iterator = mesocycloneTileList.iterator();
            while (iterator.hasNext()) {
                add(iterator.next());
            }
            repaint();
        }
    }
}
