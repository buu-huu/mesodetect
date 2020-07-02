import java.io.File;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        XMLFetcher xmlFetcher = new XMLFetcher(new OpenDataConfiguration());
        try {
            //xmlFetcher.downloadOpenData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OpenDataReader odr = new OpenDataReader(new File("C:\\data\\mesodetect\\xmlfiles\\meso_20200702_0120.xml"));
        odr.parseRadarStations();
        odr.parseMesocycloneEvents();
        List<Mesocyclone> mesocyclones = odr.getMesocycloneList();
    }
}
