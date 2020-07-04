import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MesocycloneTile extends JPanel {
    private BufferedImage image;
    private double latitude, longitude;

    private int width = 50;
    private int height = 50;

    static final double LONGITUDE_LEFT = 5.866944;
    static final double LONGITUDE_RIGHT = 15.041675;
    static final double LATITUDE_TOP = 55.057857;
    static final double LATITUDE_BOTTOM = 47.270293;
    static final double LONGITUDE_DIFFERENCE = LONGITUDE_RIGHT - LONGITUDE_LEFT;
    static final double LATITUDE_DIFFERENCE = LATITUDE_TOP - LATITUDE_BOTTOM;

    public MesocycloneTile(int intensity, double longitude, double latitude) throws IOException {

        switch (intensity) {
            case 1:
                image = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "\\res\\meso_icons\\meso_1.png"));
                break;
            case 2:
                image = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "\\res\\meso_icons\\meso_2.png"));
                break;
            case 3:
                image = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "\\res\\meso_icons\\meso_3.png"));
                break;
            case 4:
                image = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "\\res\\meso_icons\\meso_4.png"));
                break;
            case 5:
                image = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "\\res\\meso_icons\\meso_5.png"));
                break;
            default:
                System.out.println("Error during loading meso tiles...");
                break;
        }

        this.latitude = latitude;
        this.longitude = longitude;

        setSize(width, height);
        setPosition();
    }

    public void setPosition() {
        setBounds(convertLongToX(longitude) - (width/2), MapPanel.PANEL_HEIGHT - (convertLatToY(latitude)) - height, width, height);
    }
    public void setPosition(int x, int y) {
        setBounds(x - (width/2), y - height, width, height);
    }

    public int convertLongToX(double longitude) {
        double ratio = (longitude - MesocycloneTile.LONGITUDE_LEFT) / MesocycloneTile.LONGITUDE_DIFFERENCE;
        System.out.println("Longitude: " + longitude);
        System.out.println("LON_LEFT: " + LONGITUDE_LEFT);
        return (int) Math.round(ratio * MapPanel.PANEL_WIDTH);
    }

    public int convertLatToY(double latitude) {
        double ratio = (latitude - MesocycloneTile.LATITUDE_BOTTOM) / MesocycloneTile.LATITUDE_DIFFERENCE;
        return (int) Math.round(ratio * MapPanel.PANEL_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image,0, 0, width, height, this);
    }
}
