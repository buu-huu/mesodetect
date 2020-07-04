public class OpenDataConfiguration {
    private final String DEFAULT_OPEN_DATA_URL = "https://opendata.dwd.de/weather/radar/mesocyclones/";
    private final String DEFAULT_OPEN_DATA_NAME = "meso_20200702_1715.xml";
    private String openDataURL;
    private String openDataName;

    public OpenDataConfiguration() {
        this.openDataURL = DEFAULT_OPEN_DATA_URL;
        this.openDataName = DEFAULT_OPEN_DATA_NAME;
    }

    public OpenDataConfiguration(String openDataURL, String openDataName) {
        this.openDataURL = openDataURL;
        this.openDataName = openDataName;
    }

    public void setOpenDataURL(String openDataURL) {
        this.openDataURL = openDataURL;
    }

    public void setOpenDataName(String openDataName) {
        this.openDataName = openDataName;
    }

    public String getOpenDataURL() {
        return this.openDataURL;
    }

    public String getOpenDataName() {
        return this.openDataName;
    }
}
