public class RadarStation {
    private String id;
    private boolean isAvailable;

    public RadarStation(String id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public static String getFullStationName(String stationShort) {
        String name;

        switch (stationShort.toUpperCase()) {
            case "ASB":
                name =  "ASR Borkum";
                break;

            case "BOO":
                name =  "Boostedt";
                break;

            case "ROS":
                name =  "Rostock";
                break;

            case "HNR":
                name =  "Hannover";
                break;

            case "UMD":
                name =  "Ummendorf";
                break;

            case "PRO":
                name =  "Proetzel";
                break;

            case "ESS":
                name =  "Essen";
                break;

            case "FLD":
                name =  "Flechtdorf";
                break;

            case "DRS":
                name =  "Dresden";
                break;

            case "NEU":
                name =  "Neuhaus";
                break;

            case "NHB":
                name =  "Neuheilenbach";
                break;

            case "OFT":
                name =  "Offenthal";
                break;

            case "EIS":
                name =  "Eisberg";
                break;

            case "TUR":
                name =  "Tuerkheim";
                break;

            case "ISN":
                name =  "Isen";
                break;

            case "FBG":
                name =  "Feldberg";
                break;

            case "MEM":
                name =  "Memmingen";
                break;

            default:
                name =  "UNVALID";
                break;
        }

        return name;
    }

    //////////////////////
    // GETTER/SETTER
    //////////////////////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
