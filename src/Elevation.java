import java.util.List;
import java.util.ListIterator;

/**
 * Represents the elevations of radar sweeps.
 * @author Luca Schwarz
 */
public class Elevation {
    private String radarStation;
    private List<Double> angles;

    /**
     * Constructor only for specific radar station and a list of angles.
     * @param radarStation name of the radar station
     * @param angles angles where mesofeatures were detected
     */
    public Elevation(String radarStation, List<Double> angles) {
        this.radarStation = radarStation.toUpperCase();
        this.angles = angles;
    }

    /**
     * Beautified toString method.
     * @return station and angles as string
     */
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
