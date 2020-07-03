import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenDataReader {
    private File xmlFile;
    private List<Mesocyclone> mesocycloneList = new ArrayList<>();
    private List<RadarStation> radarStationList = new ArrayList<>();

    public OpenDataReader(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public void parseRadarStations() {
        if (xmlFile == null) {
            System.out.println("No XML file specified!");
            return;
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Get radar-stations-tag in nList
            NodeList nListRadarStations = document.getElementsByTagName("radar-stations");

            if (nListRadarStations.getLength() > 1) {
                System.out.println("Check XML file. Multiple radar-station-tags found. Using only first.");
            }
            String stations = nListRadarStations.item(0).getTextContent();
            String[] stationStringList = stations.split("\\s*,\\s*");

            for (String station : stationStringList) {
                // Check if station id is uppercase or lowercase
                if (!station.equals(station.toLowerCase())) {
                    radarStationList.add(new RadarStation(station.toUpperCase(), true));
                } else {
                    radarStationList.add(new RadarStation(station.toUpperCase(), false));
                }
            }
            System.out.println("Parsed radar stations!");

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Error during parsing of XML file: " + e.toString());
        } catch (IOException e) {
            System.out.println("Error during reading of XML file: " + e.toString());
        }
    }

    public void parseMesocycloneEvents() {
        if (xmlFile == null) {
            System.out.println("No XML file specified!");
            return;
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nListEvents = document.getElementsByTagName("event");

            mesocycloneList.clear(); // Clear the list

            // Iterate through each event (mesocyclone)
            for (int event = 0; event < nListEvents.getLength(); event++) {
                int id;
                String time;
                double latitude;
                double longitude;
                double polarMotion;
                double majorAxis;
                double minorAxis;
                int orientation;
                double shearMean;
                double shearMax;
                double momentumMean;
                double momentumMax;
                double diameter;
                double diameterEquivalent;
                double top;
                double base;
                double echotop;
                double vil;
                int shearVectors;
                int shearFeatures;

                List<Elevation> elevations = new ArrayList<>();

                double meanDBZ;
                double maxDBZ;
                double velocityMax;
                double velocityRotationalMax;
                double velocityRotationalMean;
                double velocityRotationalMaxClosestToGround;

                int intensity;

                // Parsing here
                Node nodeEvent = nListEvents.item(event);
                Element eventElement = (Element) nodeEvent;

                id                  = Integer.parseInt(eventElement.getAttribute("ID"));
                time                = eventElement.getElementsByTagName("time").item(0).getTextContent();
                latitude            = Double.parseDouble(eventElement.getElementsByTagName("latitude").item(0).getTextContent());
                longitude           = Double.parseDouble(eventElement.getElementsByTagName("longitude").item(0).getTextContent());
                polarMotion         = Double.parseDouble(eventElement.getElementsByTagName("speed").item(0).getTextContent());
                majorAxis           = Double.parseDouble(eventElement.getElementsByTagName("major_axis").item(0).getTextContent());
                minorAxis           = Double.parseDouble(eventElement.getElementsByTagName("minor_axis").item(0).getTextContent());
                orientation         = Integer.parseInt(eventElement.getElementsByTagName("orientation").item(0).getTextContent());
                shearMean           = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_shear_mean").item(0).getTextContent());
                shearMax            = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_shear_max").item(0).getTextContent());
                momentumMean        = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_momentum_mean").item(0).getTextContent());
                momentumMax         = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_momentum_max").item(0).getTextContent());
                diameter            = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_diameter").item(0).getTextContent());
                diameterEquivalent  = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_diameter_equivalent").item(0).getTextContent());
                top                 = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_top").item(0).getTextContent());
                base                = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_base").item(0).getTextContent());
                echotop             = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_echotop").item(0).getTextContent());
                vil                 = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_vil").item(0).getTextContent());
                shearVectors        = Integer.parseInt(eventElement.getElementsByTagName("mesocyclone_shear_vectors").item(0).getTextContent());
                shearFeatures       = Integer.parseInt(eventElement.getElementsByTagName("mesocyclone_shear_features").item(0).getTextContent());

                // Parse elevations
                NodeList elevationList = eventElement.getElementsByTagName("elevation");
                for (int elevation = 0; elevation < elevationList.getLength(); elevation++) {
                    Node eNode = elevationList.item(elevation);
                    Element elevationElement = (Element) eNode;

                    String[] degrees = elevationList.item(elevation).getTextContent().split(",");

                    List<Double> degreeList = new ArrayList<>();
                    for (String degree : degrees) {
                        degreeList.add(Double.parseDouble(degree));
                    }

                    String site = elevationElement.getAttribute("site");
                    elevations.add(new Elevation(site, degreeList));
                }

                meanDBZ                                 = Double.parseDouble(eventElement.getElementsByTagName("mean_dbz").item(0).getTextContent());
                maxDBZ                                  = Double.parseDouble(eventElement.getElementsByTagName("max_dbz").item(0).getTextContent());
                velocityMax                             = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_velocity_max").item(0).getTextContent());
                velocityRotationalMax                   = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_velocity_rotational_max").item(0).getTextContent());
                velocityRotationalMean                  = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_velocity_rotational_mean").item(0).getTextContent());
                velocityRotationalMaxClosestToGround    = Double.parseDouble(eventElement.getElementsByTagName("mesocyclone_velocity_rotational_max_closest_to_ground").item(0).getTextContent());

                intensity                               = Integer.parseInt(eventElement.getElementsByTagName("meso_intensity").item(0).getTextContent());

                // Creating mesocyclone instance
                mesocycloneList.add(new MesocycloneBuilder()
                        .id(id)
                        .time(time)
                        .latitude(latitude)
                        .longitude(longitude)
                        .polarMotion(polarMotion)
                        .majorAxis(majorAxis)
                        .minorAxis(minorAxis)
                        .orientation(orientation)
                        .shearMean(shearMean)
                        .shearMax(shearMax)
                        .momentumMean(momentumMean)
                        .momentumMax(momentumMax)
                        .diameter(diameter)
                        .diameterEquivalent(diameterEquivalent)
                        .top(top)
                        .base(base)
                        .echotop(echotop)
                        .vil(vil)
                        .shearVectors(shearVectors)
                        .shearFeatures(shearFeatures)
                        .elevations(elevations)
                        .meanDBZ(meanDBZ)
                        .maxDBZ(maxDBZ)
                        .velocityMax(velocityMax)
                        .velocityRotationalMax(velocityRotationalMax)
                        .velocityRotationalMean(velocityRotationalMean)
                        .velocityRotationalMaxClosestToGround(velocityRotationalMaxClosestToGround)
                        .intensity(intensity)
                        .buildMesocyclone());
            }

            System.out.println("Created mesocyclone objects!");

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Error during parsing of XML file: " + e.toString());
        } catch (IOException e) {
            System.out.println("Error during reading of XML file: " + e.toString());
        }
    }

    //////////////////////
    // GETTER/SETTER
    //////////////////////
    public List<Mesocyclone> getMesocycloneList() {
        return this.mesocycloneList;
    }

    public List<RadarStation> getRadarStationList() {
        return this.radarStationList;
    }

    public File getXmlFile() {
        return this.xmlFile;
    }

    public void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
        System.out.println("Set new XML file.");
    }
}
