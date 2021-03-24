import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * Descriptionframe wich shows the legend of the map with different intensities / severities
 * for mesocyclones and explains how a current and historic mesocyclone looks.
 * @author Luca Schwarz
 */
public class DescriptionFrame extends JFrame {
    private JLabel descriptionLabel;
    private JPanel mainPanel;
    private DescriptionFramePanel descriptionFramePanel;

    private final int WIDTH = 325;
    private final int HEIGHT = 225;

    public DescriptionFrame() {
        initUI();
    }

    /**
     * Initializes the UI
     */
    private void initUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Because of "manual" titlebar (at North)

        try {
            descriptionFramePanel = new DescriptionFramePanel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        descriptionLabel = new JLabel("Nowcast Object Mesocyclone");
        descriptionLabel.setOpaque(true);
        descriptionLabel.setBackground(Color.BLUE);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(descriptionLabel, BorderLayout.NORTH);
        mainPanel.add(descriptionFramePanel, BorderLayout.CENTER);

        add(mainPanel);

        // Implement ability to drag Frame around by clicking anywhere
        DescriptionFrame.FrameDragListener frameDragListener = new DescriptionFrame.FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        setTitle("Description");
        setSize(WIDTH, HEIGHT);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
    }

    /**
     * Listener for ability to drag frame around by clicking and holding
     * anywhere in the frame.
     */
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

    /**
     * Holds all stuff excluding the title bar.
     */
    public class DescriptionFramePanel extends JPanel {
        JLabel lblCurrent, lblHistoric, lblCurrentDesc, lblHistoricDesc;
        ColorLabel lbl1color, lbl2color, lbl3color, lbl4color, lbl5color;
        ColorDescriptionLabel lbl1desc, lbl2desc, lbl3desc, lbl4desc, lbl5desc;
        Image mesoCurrentImage = ImageIO.read(new File(System.getProperty("user.dir")
                + File.separator
                + "res"
                + File.separator
                + "meso_icons"
                + File.separator
                + "meso_3.png"));
        Image mesoHistoricImage = ImageIO.read(new File(System.getProperty("user.dir")
                + File.separator
                + "res"
                + File.separator
                + "meso_icons"
                + File.separator
                + "meso_3_hist.png"));

        public DescriptionFramePanel() throws IOException {
            this.setLayout(null);
            this.setBackground(Color.WHITE);

            lblCurrent = new JLabel();
            lblCurrent.setIcon(new ImageIcon(mesoCurrentImage.getScaledInstance(65, 65, Image.SCALE_SMOOTH)));
            lblCurrent.setBounds(20, 20, 65, 65);
            lblCurrentDesc = new JLabel("Current Meso");
            lblCurrentDesc.setBounds(90, 20, 100, 65);
            lblCurrentDesc.setVerticalTextPosition(JLabel.CENTER);
            lblCurrentDesc.setFont(new Font("Courier", Font.PLAIN, 12));

            lblHistoric = new JLabel();
            lblHistoric.setIcon(new ImageIcon(mesoHistoricImage.getScaledInstance(65, 65, Image.SCALE_SMOOTH)));
            lblHistoric.setBounds(20, 110, 65, 65);
            lblHistoricDesc = new JLabel("Historic Meso");
            lblHistoricDesc.setBounds(90, 110, 100, 65);
            lblHistoricDesc.setVerticalTextPosition(JLabel.CENTER);
            lblHistoricDesc.setFont(new Font("Courier", Font.PLAIN, 12));

            lbl1color = new ColorLabel(1, 200, 25);
            lbl2color = new ColorLabel(2, 200, 50);
            lbl3color = new ColorLabel(3, 200, 75);
            lbl4color = new ColorLabel(4, 200, 100);
            lbl5color = new ColorLabel(5, 200, 125);

            lbl1desc = new ColorDescriptionLabel(1, 235, 25);
            lbl2desc = new ColorDescriptionLabel(2, 235, 50);
            lbl3desc = new ColorDescriptionLabel(3, 235, 75);
            lbl4desc = new ColorDescriptionLabel(4, 235, 100);
            lbl5desc = new ColorDescriptionLabel(5, 235, 125);

            add(lblCurrent);
            add(lblHistoric);
            add(lblCurrentDesc);
            add(lblHistoricDesc);

            add(lbl1color);
            add(lbl2color);
            add(lbl3color);
            add(lbl4color);
            add(lbl5color);

            add(lbl1desc);
            add(lbl2desc);
            add(lbl3desc);
            add(lbl4desc);
            add(lbl5desc);
        }

        /**
         * Special label that looks like a colored square
         * that represents one of the five intensity colors.
         */
        public class ColorLabel extends JLabel {
            Color color;
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            final int WIDTH = 25;
            final int HEIGHT = 25;
            final Color col1 = new Color(101, 179, 48);
            final Color col2 = new Color(240, 229, 28);
            final Color col3 = new Color(247, 176, 23);
            final Color col4 = new Color(228, 28,  32);
            final Color col5 = new Color(132, 71,  149);

            /**
             * Constructor
             * @param intensity creates color according to intensity
             * @param x x position of label
             * @param y y position of label
             */
            public ColorLabel(int intensity, int x, int y) {
                switch (intensity) {
                    case 1:
                        this.color = col1;
                        break;
                    case 2:
                        this.color = col2;
                        break;
                    case 3:
                        this.color = col3;
                        break;
                    case 4:
                        this.color = col4;
                        break;
                    case 5:
                        this.color = col5;
                        break;
                    default:
                        System.out.println("Wrong intensityindex given! Using standardcolor.");
                        this.color = col1;
                        break;
                }

                this.setBounds(x, y, WIDTH, HEIGHT);
                this.setBackground(this.color);
                this.setOpaque(true);
                this.setBorder(border);
            }
        }

        /**
         * Description label of {@link ColorLabel} to describe the intensity per color
         */
        public class ColorDescriptionLabel extends JLabel {
            final int WIDTH = 80;
            final int HEIGHT = 25;

            Font font = new Font("Courier", Font.PLAIN, 12);

            /**
             *
             * @param intensity creates text according to intensity
             * @param x x position of label
             * @param y y position of label
             */
            public ColorDescriptionLabel(int intensity, int x, int y) {
                String intensityString = "Intensity ";
                switch (intensity) {
                    case 1:
                        intensityString += "1";
                        break;
                    case 2:
                        intensityString += "2";
                        break;
                    case 3:
                        intensityString += "3";
                        break;
                    case 4:
                        intensityString += "4";
                        break;
                    case 5:
                        intensityString += "5";
                        break;
                    default:
                        System.out.println("Wrong intensity given for ColorDescriptionLabel. Using default.");
                        break;
                }

                this.setBackground(Color.WHITE);
                this.setFont(font);
                this.setText(intensityString);
                this.setVerticalTextPosition(JLabel.CENTER);
                this.setBounds(x, y, WIDTH, HEIGHT);
                this.setOpaque(true);
            }
        }
    }
}
