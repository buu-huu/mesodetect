import java.io.*;
import java.net.URL;

public class XMLFetcher {
    private String openDataURL;
    private String openDataName;
    private final String localDownloadPath = System.getProperty("user.dir") + File.separator + "xmlfiles";

    public XMLFetcher(OpenDataConfiguration odc) {
        this.openDataURL = odc.getOpenDataURL();
        this.openDataName = odc.getOpenDataName();
    }

    public void downloadOpenData() throws Exception {
        // Read file from Opendata server
        URL url = new URL(openDataURL + openDataName);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String i; // Iterator
        String xmlString = "";

        while ((i = br.readLine()) != null) {
            xmlString += i;
            xmlString += "\n";
        }
        br.close();

        // Write XML to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(localDownloadPath + File.separator + openDataName));
        writer.write(xmlString);

        writer.close();
        System.out.println("Downloaded XML file");
    }

    //////////////////////
    // GETTER/SETTER
    //////////////////////

    public String getOpenDataURL() {
        return openDataURL;
    }

    public void setOpenDataURL(String openDataURL) {
        this.openDataURL = openDataURL;
    }

    public String getOpenDataName() {
        return openDataName;
    }

    public void setOpenDataName(String openDataName) {
        this.openDataName = openDataName;
    }

    public String getLocalDownloadPath() {
        return localDownloadPath;
    }
}
