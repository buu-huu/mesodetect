import java.util.List;

public class Mesocyclone {
    private int id;
    private String time;
    private double latitude;
    private double longitude;
    private double polarMotion = 0;   // Currently not used. Using Default
    private double majorAxis = 10;    // Currently not used. Using Default
    private double minorAxis = 10;    // Currently not used. Using Default
    private int orientation = 0;      // Currently not used. Using Default
    private double shearMean;
    private double shearMax;
    private double momentumMean;
    private double momentumMax;
    private double diameter;
    private double diameterEquivalent;
    private double top;
    private double base;
    private double echotop;
    private double vil;
    private int shearVectors;
    private int shearFeatures;

    private List<Elevation> elevations;

    private double meanDBZ;
    private double maxDBZ;
    private double velocityMax;
    private double velocityRotationalMax;
    private double velocityRotationalMean;
    private double velocityRotationalMaxClosestToGround;

    private int intensity;

    public Mesocyclone(int id, String time, double latitude, double longitude, double polarMotion,
                       double majorAxis, double minorAxis, int orientation, double shearMean, double shearMax,
                       double momentumMean, double momentumMax, double diameter, double diameterEquivalent,
                       double top, double base, double echotop, double vil, int shearVectors, int shearFeatures,
                       List<Elevation> elevations, double meanDBZ, double maxDBZ, double velocityMax,
                       double velocityRotationalMax, double velocityRotationalMean,
                       double velocityRotationalMaxClosestToGround, int intensity) {
        this.id = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.polarMotion = polarMotion;
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
        this.orientation = orientation;
        this.shearMean = shearMean;
        this.shearMax = shearMax;
        this.momentumMean = momentumMean;
        this.momentumMax = momentumMax;
        this.diameter = diameter;
        this.diameterEquivalent = diameterEquivalent;
        this.top = top;
        this.base = base;
        this.echotop = echotop;
        this.vil = vil;
        this.shearVectors = shearVectors;
        this.shearFeatures = shearFeatures;
        this.elevations = elevations;
        this.meanDBZ = meanDBZ;
        this.maxDBZ = maxDBZ;
        this.velocityMax = velocityMax;
        this.velocityRotationalMax = velocityRotationalMax;
        this.velocityRotationalMean = velocityRotationalMean;
        this.velocityRotationalMaxClosestToGround = velocityRotationalMaxClosestToGround;
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "Mesocyclone{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", polarMotion=" + polarMotion +
                ", majorAxis=" + majorAxis +
                ", minorAxis=" + minorAxis +
                ", orientation=" + orientation +
                ", shearMean=" + shearMean +
                ", shearMax=" + shearMax +
                ", momentumMean=" + momentumMean +
                ", momentumMax=" + momentumMax +
                ", diameter=" + diameter +
                ", diameterEquivalent=" + diameterEquivalent +
                ", top=" + top +
                ", base=" + base +
                ", echotop=" + echotop +
                ", vil=" + vil +
                ", shearVectors=" + shearVectors +
                ", shearFeatures=" + shearFeatures +
                ", elevations=" + elevations +
                ", meanDBZ=" + meanDBZ +
                ", maxDBZ=" + maxDBZ +
                ", velocityMax=" + velocityMax +
                ", velocityRotationalMax=" + velocityRotationalMax +
                ", velocityRotationalMean=" + velocityRotationalMean +
                ", velocityRotationalMaxClosestToGround=" + velocityRotationalMaxClosestToGround +
                ", intensity=" + intensity +
                '}';
    }

    //////////////////////
    // GETTER/SETTER
    //////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPolarMotion() {
        return polarMotion;
    }

    public void setPolarMotion(double polarMotion) {
        this.polarMotion = polarMotion;
    }

    public double getMajorAxis() {
        return majorAxis;
    }

    public void setMajorAxis(double majorAxis) {
        this.majorAxis = majorAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public double getShearMean() {
        return shearMean;
    }

    public void setShearMean(double shearMean) {
        this.shearMean = shearMean;
    }

    public double getShearMax() {
        return shearMax;
    }

    public void setShearMax(double shearMax) {
        this.shearMax = shearMax;
    }

    public double getMomentumMean() {
        return momentumMean;
    }

    public void setMomentumMean(double momentumMean) {
        this.momentumMean = momentumMean;
    }

    public double getMomentumMax() {
        return momentumMax;
    }

    public void setMomentumMax(double momentumMax) {
        this.momentumMax = momentumMax;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameterEquivalent() {
        return diameterEquivalent;
    }

    public void setDiameterEquivalent(double diameterEquivalent) {
        this.diameterEquivalent = diameterEquivalent;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getEchotop() {
        return echotop;
    }

    public void setEchotop(double echotop) {
        this.echotop = echotop;
    }

    public double getVil() {
        return vil;
    }

    public void setVil(double vil) {
        this.vil = vil;
    }

    public int getShearVectors() {
        return shearVectors;
    }

    public void setShearVectors(int shearVectors) {
        this.shearVectors = shearVectors;
    }

    public int getShearFeatures() {
        return shearFeatures;
    }

    public void setShearFeatures(int shearFeatures) {
        this.shearFeatures = shearFeatures;
    }

    public List<Elevation> getElevations() {
        return elevations;
    }

    public void setElevations(List<Elevation> elevations) {
        this.elevations = elevations;
    }

    public double getMeanDBZ() {
        return meanDBZ;
    }

    public void setMeanDBZ(double meanDBZ) {
        this.meanDBZ = meanDBZ;
    }

    public double getMaxDBZ() {
        return maxDBZ;
    }

    public void setMaxDBZ(double maxDBZ) {
        this.maxDBZ = maxDBZ;
    }

    public double getVelocityMax() {
        return velocityMax;
    }

    public void setVelocityMax(double velocityMax) {
        this.velocityMax = velocityMax;
    }

    public double getVelocityRotationalMax() {
        return velocityRotationalMax;
    }

    public void setVelocityRotationalMax(double velocityRotationalMax) {
        this.velocityRotationalMax = velocityRotationalMax;
    }

    public double getVelocityRotationalMean() {
        return velocityRotationalMean;
    }

    public void setVelocityRotationalMean(double velocityRotationalMean) {
        this.velocityRotationalMean = velocityRotationalMean;
    }

    public double getVelocityRotationalMaxClosestToGround() {
        return velocityRotationalMaxClosestToGround;
    }

    public void setVelocityRotationalMaxClosestToGround(double velocityRotationalMaxClosestToGround) {
        this.velocityRotationalMaxClosestToGround = velocityRotationalMaxClosestToGround;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}