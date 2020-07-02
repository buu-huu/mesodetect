public class RadarStation {
    private String id;
    private boolean isAvailable;

    public RadarStation(String id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
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
