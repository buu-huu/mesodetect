import java.util.List;

public class MesocycloneBuilder {
    private int id = 0;
    private String time = "";
    private double latitude = 0;
    private double longitude = 0;
    private double polarMotion = 0;
    private double majorAxis = 0;
    private double minorAxis = 0;
    private int orientation = 0;
    private double shearMean = 0;
    private double shearMax = 0;
    private double momentumMean = 0;
    private double momentumMax = 0;
    private double diameter = 0;
    private double diameterEquivalent = 0;
    private double top = 0;
    private double base = 0;
    private double echotop = 0;
    private double vil = 0;
    private int shearVectors = 0;
    private int shearFeatures = 0;

    private List<Elevation> elevations = null;

    private double meanDBZ = 0;
    private double maxDBZ = 0;
    private double velocityMax = 0;
    private double velocityRotationalMax = 0;
    private double velocityRotationalMean = 0;
    private double velocityRotationalMaxClosestToGround = 0;

    private int intensity = 0;

    public MesocycloneBuilder() {}

    public Mesocyclone buildMesocyclone() {
        return new Mesocyclone(id, time, latitude, longitude, polarMotion, majorAxis, minorAxis, orientation,
                shearMean, shearMax, momentumMean, momentumMax, diameter, diameterEquivalent, top, base, echotop,
                vil, shearVectors, shearFeatures,elevations, meanDBZ, maxDBZ, velocityMax, velocityRotationalMax,
                velocityRotationalMean, velocityRotationalMaxClosestToGround, intensity);
    }

    public MesocycloneBuilder id(int id) {
        this.id = id;
        return this;
    }

    public MesocycloneBuilder time(String time) {
        this.time = time;
        return this;
    }

    public MesocycloneBuilder latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public MesocycloneBuilder longitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public MesocycloneBuilder polarMotion(double polarMotion) {
        this.polarMotion = polarMotion;
        return this;
    }

    public MesocycloneBuilder majorAxis(double majorAxis) {
        this.majorAxis = majorAxis;
        return this;
    }

    public MesocycloneBuilder minorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
        return this;
    }

    public MesocycloneBuilder orientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public MesocycloneBuilder shearMean(double shearMean) {
        this.shearMean = shearMean;
        return this;
    }

    public MesocycloneBuilder shearMax(double shearMax) {
        this.shearMax = shearMax;
        return this;
    }

    public MesocycloneBuilder momentumMean(double momentumMean) {
        this.momentumMean = momentumMean;
        return this;
    }

    public MesocycloneBuilder momentumMax(double momentumMax) {
        this.momentumMax = momentumMax;
        return this;
    }

    public MesocycloneBuilder diameter(double diameter) {
        this.diameter = diameter;
        return this;
    }

    public MesocycloneBuilder diameterEquivalent(double diameterEquivalent) {
        this.diameterEquivalent = diameterEquivalent;
        return this;
    }

    public MesocycloneBuilder top(double top) {
        this.top = top;
        return this;
    }

    public MesocycloneBuilder base(double base) {
        this.base = base;
        return this;
    }

    public MesocycloneBuilder echotop(double echotop) {
        this.echotop = echotop;
        return this;
    }

    public MesocycloneBuilder vil(double vil) {
        this.vil = vil;
        return this;
    }

    public MesocycloneBuilder shearVectors(int shearVectors) {
        this.shearVectors = shearVectors;
        return this;
    }

    public MesocycloneBuilder shearFeatures(int shearFeatures) {
        this.shearFeatures = shearFeatures;
        return this;
    }

    public MesocycloneBuilder elevations(List<Elevation> elevations) {
        this.elevations = elevations;
        return this;
    }

    public MesocycloneBuilder meanDBZ(double meanDBZ) {
        this.meanDBZ = meanDBZ;
        return this;
    }

    public MesocycloneBuilder maxDBZ(double maxDBZ) {
        this.maxDBZ = maxDBZ;
        return this;
    }

    public MesocycloneBuilder velocityMax(double velocityMax) {
        this.velocityMax = velocityMax;
        return this;
    }

    public MesocycloneBuilder velocityRotationalMax(double velocityRotationalMax) {
        this.velocityRotationalMax = velocityRotationalMax;
        return this;
    }

    public MesocycloneBuilder velocityRotationalMean(double velocityRotationalMean) {
        this.velocityRotationalMean = velocityRotationalMean;
        return this;
    }

    public MesocycloneBuilder velocityRotationalMaxClosestToGround(double velocityRotationalMaxClosestToGround) {
        this.velocityRotationalMaxClosestToGround = velocityRotationalMaxClosestToGround;
        return this;
    }

    public MesocycloneBuilder intensity(int intensity) {
        this.intensity = intensity;
        return this;
    }
}
