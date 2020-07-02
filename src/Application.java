import java.io.File;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        XMLFetcher xmlFetcher = new XMLFetcher(new OpenDataConfiguration());
        try {
            xmlFetcher.downloadOpenData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OpenDataReader odr = new OpenDataReader(new File(xmlFetcher.getLocalDownloadPath() + "\\" + xmlFetcher.getOpenDataName()));
        odr.parseRadarStations();
        odr.parseMesocycloneEvents();
        List<Mesocyclone> mesocyclones = odr.getMesocycloneList();

        new MainWindow(mesocyclones).setVisible(true);
    }
}
