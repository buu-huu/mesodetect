import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class MainWindow extends JFrame {
    MapPanel mapPanel;
    InformationPanel informationPanel;
    MenuBar menuBar;

    final int WIDTH = 1100;
    final int HEIGHT = 980;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        try {
            mapPanel = new MapPanel(this);
        } catch (IOException e) {
            System.out.println("Error loading background map: " + e.toString());
        }
        informationPanel = new InformationPanel(this);
        menuBar = new MenuBar();

        add(mapPanel, BorderLayout.CENTER);
        add(informationPanel, BorderLayout.EAST);
        add(menuBar, BorderLayout.NORTH);
        pack();

        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        setTitle("Mesodetect  |  v1.0  |  \u00a9 Luca Schwarz");
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
