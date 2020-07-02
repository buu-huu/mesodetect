import java.util.List;
import java.util.ListIterator;

public class Elevation {
    private String radarStation;
    private List<Double> angles;

    public Elevation(String radarStation, List<Double> angles) {
        this.radarStation = radarStation.toUpperCase();
        this.angles = angles;
    }

    public String toString() {
        String s = this.radarStation + ": ";

        ListIterator<Double> iterator = this.angles.listIterator();
        while (iterator.hasNext()) {
            s += iterator.next().toString();
            s += ", ";
        }

        return s;
    }

    //////////////////////
    // GETTER/SETTER
    //////////////////////
    public String getRadarStation() {
        return radarStation;
    }

    public void setRadarStation(String radarStation) {
        this.radarStation = radarStation.toUpperCase();
    }

    public List<Double> getAngles() {
        return angles;
    }

    public void setAngles(List<Double> angles) {
        this.angles = angles;
    }
}
