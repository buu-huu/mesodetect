import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame {
    MapPanel mapPanel;
    InformationPanel informationPanel;
    MenuBar menuBar;
    DescriptionFrame descriptionFrame;

    XMLFetcher xmlFetcher;
    OpenDataReader odr;

    Mesocyclone[] mesocyclones;
    List<RadarStation> radarStationList;

    final int WIDTH = 1100;
    final int HEIGHT = 980;

    public MainFrame() {
        if (xmlFetcher == null) {
            xmlFetcher = new XMLFetcher(new OpenDataConfiguration());
        }
        if (odr == null) {
            odr = new OpenDataReader(new File(xmlFetcher.getLocalDownloadPath() + File.separator + xmlFetcher.getOpenDataName()));
        }

        downloadData();
        initUI();

        descriptionFrame = new DescriptionFrame();
        descriptionFrame.setVisible(true);
    }

    public void downloadData() {
        try {
            xmlFetcher.downloadOpenData();
        } catch (Exception e) {
            System.out.println("Can't download data from Open Data Server: " + e.toString());
        }

        odr.parseRadarStations();
        odr.parseMesocycloneEvents();

        // Getting radarstations from parser
        radarStationList = odr.getRadarStationList();

        // Getting mesocyclones from parser
        mesocyclones = new Mesocyclone[odr.getMesocycloneList().size()];
        mesocyclones = odr.getMesocycloneList().toArray(mesocyclones);
    }

    public Mesocyclone[] getMesocyclones() {
        return this.mesocyclones;
    }
    public List<RadarStation> getRadarStationList() {
        return this.radarStationList;
    }

    private void initUI() {
        setLayout(new BorderLayout());

        try {
            mapPanel = new MapPanel(this);
        } catch (IOException e) {
            System.out.println("Error loading background map: " + e.toString());
        }
        informationPanel = new InformationPanel(this, mesocyclones, radarStationList);
        menuBar = new MenuBar();

        add(informationPanel, BorderLayout.EAST);
        add(mapPanel, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);
        pack();

        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        setTitle("Mesodetect  |  v1.0 Beta");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static class FrameDragListener extends MouseAdapter {
        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
}
