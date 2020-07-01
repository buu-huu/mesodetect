import java.util.HashMap;

public class Mesocyclone {
    private int id;
    private String time;
    private double latitude;
    private double longitude;
    private final double polarMotion = 0;
    private final double majorAxis = 10;
    private final double minorAxis = 10;
    private final int orientation = 0;
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

    private HashMap<String, Double> elevations;

    private double meanDBZ;
    private double maxDBZ;
    private double velocityMax;
    private double velocityRotationalMax;
    private double velocityRotationalMean;
    private double velocityRotationalMaxClosestToGround;

    private int intensity;
}