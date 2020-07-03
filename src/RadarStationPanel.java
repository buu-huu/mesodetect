import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RadarStationPanel extends JPanel {
    RadarStationLabel asbLabel, booLabel, rosLabel, hnrLabel, umdLabel, proLabel, essLabel, fldLabel, drsLabel,
            neuLabel, nhbLabel, oftLabel, eisLabel, turLabel, isnLabel, fbgLabel, memLabel;
    List<RadarStation> radarStationList;
    GridLayout gridLayout;
    Color bg = Color.DARK_GRAY;
    TitledBorder border = new TitledBorder("STATION AVAILABILITY");

    public RadarStationPanel(List<RadarStation> radarStationList) {
        this.radarStationList = radarStationList;

        initLabels();
        setBackground(bg);

        border.setTitleFont(new Font("Courier", Font.PLAIN, 10));
        border.setTitleColor(Color.WHITE);
        setBorder(border);

        gridLayout = new GridLayout(5, 4);
        setLayout(gridLayout);

        add(asbLabel);
        add(booLabel);
        add(rosLabel);
        add(hnrLabel);
        add(umdLabel);
        add(proLabel);
        add(essLabel);
        add(fldLabel);
        add(drsLabel);
        add(neuLabel);
        add(nhbLabel);
        add(oftLabel);
        add(eisLabel);
        add(turLabel);
        add(isnLabel);
        add(fbgLabel);
        add(memLabel);
    }

    private void initLabels() {
        asbLabel = new RadarStationLabel("ASB");
        booLabel = new RadarStationLabel("BOO");
        rosLabel = new RadarStationLabel("ROS");
        hnrLabel = new RadarStationLabel("HNR");
        umdLabel = new RadarStationLabel("UMD");
        proLabel = new RadarStationLabel("PRO");
        essLabel = new RadarStationLabel("ESS");
        fldLabel = new RadarStationLabel("FLD");
        drsLabel = new RadarStationLabel("DRS");
        neuLabel = new RadarStationLabel("NEU");
        nhbLabel = new RadarStationLabel("NHB");
        oftLabel = new RadarStationLabel("OFT");
        eisLabel = new RadarStationLabel("EIS");
        turLabel = new RadarStationLabel("TUR");
        isnLabel = new RadarStationLabel("ISN");
        fbgLabel = new RadarStationLabel("FBG");
        memLabel = new RadarStationLabel("MEM");
    }

    public void setColors() {
        if (radarStationList != null) {
            if (radarStationList.size() != 0) {
                // Iterator + switch case
                Iterator<RadarStation> iterator = radarStationList.iterator();
                while (iterator.hasNext()) {
                    RadarStation station = iterator.next();

                    switch(station.getId().toUpperCase()) {
                        case "ASB":
                            if (station.isAvailable()) {
                                asbLabel.setActive();
                            }
                            else {
                                asbLabel.setNotUp();
                            }
                            break;

                        case "BOO":
                            if (station.isAvailable()) {
                                booLabel.setActive();
                            }
                            else {
                                booLabel.setNotUp();
                            }
                            break;

                        case "ROS":
                            if (station.isAvailable()) {
                                rosLabel.setActive();
                            }
                            else {
                                rosLabel.setNotUp();
                            }
                            break;

                        case "HNR":
                            if (station.isAvailable()) {
                                hnrLabel.setActive();
                            }
                            else {
                                hnrLabel.setNotUp();
                            }
                            break;

                        case "UMD":
                            if (station.isAvailable()) {
                                umdLabel.setActive();
                            }
                            else {
                                umdLabel.setNotUp();
                            }
                            break;

                        case "PRO":
                            if (station.isAvailable()) {
                                proLabel.setActive();
                            }
                            else {
                                proLabel.setNotUp();
                            }
                            break;

                        case "ESS":
                            if (station.isAvailable()) {
                                essLabel.setActive();
                            }
                            else {
                                proLabel.setNotUp();
                            }
                            break;

                        case "FLD":
                            if (station.isAvailable()) {
                                fldLabel.setActive();
                            }
                            else {
                                proLabel.setNotUp();
                            }
                            break;

                        case "DRS":
                            if (station.isAvailable()) {
                                drsLabel.setActive();
                            }
                            else {
                                drsLabel.setNotUp();
                            }
                            break;

                        case "NEU":
                            if (station.isAvailable()) {
                                neuLabel.setActive();
                            }
                            else {
                                neuLabel.setNotUp();
                            }
                            break;

                        case "NHB":
                            if (station.isAvailable()) {
                                nhbLabel.setActive();
                            }
                            else {
                                nhbLabel.setNotUp();
                            }
                            break;

                        case "OFT":
                            if (station.isAvailable()) {
                                oftLabel.setActive();
                            }
                            else {
                                oftLabel.setNotUp();
                            }
                            break;

                        case "EIS":
                            if (station.isAvailable()) {
                                eisLabel.setActive();
                            }
                            else {
                                eisLabel.setNotUp();
                            }
                            break;

                        case "TUR":
                            if (station.isAvailable()) {
                                turLabel.setActive();
                            }
                            else {
                                turLabel.setNotUp();
                            }
                            break;

                        case "ISN":
                            if (station.isAvailable()) {
                                isnLabel.setActive();
                            }
                            else {
                                isnLabel.setNotUp();
                            }
                            break;

                        case "FBG":
                            if (station.isAvailable()) {
                                fbgLabel.setActive();
                            }
                            else {
                                fbgLabel.setNotUp();
                            }
                            break;

                        case "MEM":
                            if (station.isAvailable()) {
                                memLabel.setActive();
                            }
                            else {
                                memLabel.setNotUp();
                            }
                            break;

                        default:
                            System.out.println("Error during setting radar station colors.");
                            break;
                    }
                }
            }
            else {
                System.out.println("Cant set radarstationcolors. Size is 0");
            }
        }
        else {
            System.out.println("Cant set radarstationcolors. List is empty.");
        }
    }

    public void setRadarStationList(List<RadarStation> radarStationList) {
        this.radarStationList = radarStationList;
    }
}
