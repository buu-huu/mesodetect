import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class InformationPanel extends JPanel {
    private HeaderLabel header;
    private DescriptionLabel idLabel, timeLabel, latitudeLabel, longituteLabel, polarMotionLabel, majorAxisLabel,
        minorAxisLabel, orientationLabel, shearMeanLabel, shearMaxLabel, momentumMeanLabel, momentumMaxLabel,
        diameterLabel, diameterEquivalentLabel, topLabel, baseLabel, echotopLabel, vilLabel, shearVectorsLabel,
        shearFeaturesLabel, elevationsLabel, meanDBZLabel, maxDBZLabel, velocityMaxLabel, velocityRotationalMaxLabel,
        velocityRotationalMeanLabel, velocityRotationalMaxClosestToGroundLabel, intensityLabel;
    private DescriptionTextField idTextField, timeTextField, latitudeTextField, longitudeTextField, polarMotionTextField,
        majorAxisTextField, minorAxisTextField, orientationTextField, shearMeanTextField, shearMaxTextField,
        momentumMeanTextField, momentumMaxTextField, diameterTextField, diameterEquivalentTextField, topTextField,
        baseTextField, echotopTextField, vilTextField, shearVectorsTextField, shearFeaturesTextField, elevationsTextField,
        meanDBZTextField, maxDBZTextField, velocityMaxTextField, velocityRotationalMaxTextField, velocityRotationalMeanTextField,
        velocityRotationalMaxClosestToGroundTextField, intensityTextField;
    private StandardButton loadButton, exitButton;
    private JPanel buttonPanel;
    private MainWindow parentWindow;
    private RadarStationPanel radarStationPanel;
    private InfoNavigationPanel navigationPanel;
    private Border border = BorderFactory.createLoweredBevelBorder();

    private XMLFetcher xmlFetcher;
    private OpenDataReader odr;
    private Mesocyclone[] mesocyclones;
    private List<RadarStation> radarStationList;
    private int mesoCurrent = 0;

    public InformationPanel(MainWindow parentWindow, Mesocyclone[] mesocyclones, List<RadarStation> radarStationList) {
        this.parentWindow = parentWindow;
        this.mesocyclones = mesocyclones;
        this.radarStationList = radarStationList;

        setSize(new Dimension(500, 0));
        GridBagLayout gridBagLayout = new GridBagLayout();

        setLayout(gridBagLayout);
        setBackground(Color.GRAY);
        setBorder(border);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);

        navigationPanel = new InfoNavigationPanel();
        navigationPanel.setInformationPanel(this);

        radarStationPanel = new RadarStationPanel(radarStationList);

        initLabels();
        initTextFields();
        initButtons();

        ButtonListener buttonListener = new ButtonListener();

        loadButton.addActionListener(buttonListener);
        exitButton.addActionListener(buttonListener);

        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);

        GridBagConstraints gbc = new GridBagConstraints();

        // ROW 0
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(header, gbc);

        add(Box.createVerticalStrut(20));

        gbc.gridwidth = 1;

        // ROW 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(idTextField, gbc);

        // ROW 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(timeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(timeTextField, gbc);

        // ROW 3
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(latitudeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(latitudeTextField, gbc);

        // ROW 4
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(longituteLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(longitudeTextField, gbc);

        // ROW 5
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(polarMotionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(polarMotionTextField, gbc);

        // ROW 6
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(majorAxisLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(majorAxisTextField, gbc);

        // ROW 7
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(minorAxisLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(minorAxisTextField, gbc);

        // ROW 8
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(orientationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        add(orientationTextField, gbc);

        // ROW 9
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(shearMeanLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        add(shearMeanTextField, gbc);

        // ROW 10
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(shearMaxLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        add(shearMaxTextField, gbc);

        // ROW 11
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(momentumMeanLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        add(momentumMeanTextField, gbc);

        // ROW 12
        gbc.gridx = 0;
        gbc.gridy = 12;
        add(momentumMaxLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        add(momentumMaxTextField, gbc);

        // ROW 13
        gbc.gridx = 0;
        gbc.gridy = 13;
        add(diameterLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        add(diameterTextField, gbc);

        // ROW 14
        gbc.gridx = 0;
        gbc.gridy = 14;
        add(diameterEquivalentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;
        add(diameterEquivalentTextField, gbc);

        // ROW 15
        gbc.gridx = 0;
        gbc.gridy = 15;
        add(topLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 15;
        add(topTextField, gbc);

        // ROW 16
        gbc.gridx = 0;
        gbc.gridy = 16;
        add(baseLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 16;
        add(baseTextField, gbc);

        // ROW 17
        gbc.gridx = 0;
        gbc.gridy = 17;
        add(echotopLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 17;
        add(echotopTextField, gbc);

        // ROW 18
        gbc.gridx = 0;
        gbc.gridy = 18;
        add(vilLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 18;
        add(vilTextField, gbc);

        // ROW 19
        gbc.gridx = 0;
        gbc.gridy = 19;
        add(shearVectorsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 19;
        add(shearVectorsTextField, gbc);

        // ROW 20
        gbc.gridx = 0;
        gbc.gridy = 20;
        add(shearFeaturesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 20;
        add(shearFeaturesTextField, gbc);

        // ROW 21
        gbc.gridx = 0;
        gbc.gridy = 21;
        add(elevationsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 21;
        add(elevationsTextField, gbc);

        // ROW 22
        gbc.gridx = 0;
        gbc.gridy = 22;
        add(meanDBZLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 22;
        add(meanDBZTextField, gbc);

        // ROW 23
        gbc.gridx = 0;
        gbc.gridy = 23;
        add(maxDBZLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 23;
        add(maxDBZTextField, gbc);

        // ROW 24
        gbc.gridx = 0;
        gbc.gridy = 24;
        add(maxDBZLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 24;
        add(maxDBZTextField, gbc);

        // ROW 25
        gbc.gridx = 0;
        gbc.gridy = 25;
        add(velocityMaxLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 25;
        add(velocityMaxTextField, gbc);

        // ROW 26
        gbc.gridx = 0;
        gbc.gridy = 26;
        add(velocityRotationalMaxLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 26;
        add(velocityRotationalMaxTextField, gbc);

        // ROW 27
        gbc.gridx = 0;
        gbc.gridy = 27;
        add(velocityRotationalMeanLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 27;
        add(velocityRotationalMeanTextField, gbc);

        // ROW 28
        gbc.gridx = 0;
        gbc.gridy = 28;
        add(velocityRotationalMaxClosestToGroundLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 28;
        add(velocityRotationalMaxClosestToGroundTextField, gbc);

        // ROW 29
        gbc.gridx = 0;
        gbc.gridy = 29;
        add(intensityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 29;
        add(intensityTextField, gbc);

        // NAVIGATOR ROW
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 30;
        add(navigationPanel, gbc);

        // BUTTONROW
        gbc.gridwidth = 2;

        gbc.gridx = 0;
        gbc.gridy = 31;
        add(buttonPanel, gbc);

        // RADAR STATION ROW
        gbc.gridx = 0;
        gbc.gridy = 32;
        add(radarStationPanel, gbc);

        setPreferredSize(new Dimension(300, 0));
    }

    private void initLabels() {
        header = new HeaderLabel("Mesocyclone Data");

        idLabel = new DescriptionLabel("ID");
        timeLabel = new DescriptionLabel("TIME");
        latitudeLabel = new DescriptionLabel("LATITUDE");
        longituteLabel = new DescriptionLabel("LONGITUDE");
        polarMotionLabel = new DescriptionLabel("POLAR MOTION");
        majorAxisLabel = new DescriptionLabel("MAJOR AXIS");
        minorAxisLabel = new DescriptionLabel("MINOR AXIS");
        orientationLabel = new DescriptionLabel("ORIENTATION");
        shearMeanLabel = new DescriptionLabel("SHEAR MEAN");
        shearMaxLabel = new DescriptionLabel("SHEAR MAX");
        momentumMeanLabel = new DescriptionLabel("MOMENTUM MEAN");
        momentumMaxLabel = new DescriptionLabel("MOMENTUM MAX");
        diameterLabel = new DescriptionLabel("DIAMETER");
        diameterEquivalentLabel = new DescriptionLabel("DIAMETER EQUIVALENT");
        topLabel = new DescriptionLabel("TOP");
        baseLabel = new DescriptionLabel("BASE");
        echotopLabel = new DescriptionLabel("ECHOTOP");
        vilLabel = new DescriptionLabel("VIL");
        shearVectorsLabel = new DescriptionLabel("SHEAR VECTORS");
        shearFeaturesLabel = new DescriptionLabel("SHEAR FEATURES");
        elevationsLabel = new DescriptionLabel("ELEVATIONS");
        meanDBZLabel = new DescriptionLabel("MEAN DBZ");
        maxDBZLabel = new DescriptionLabel("MAX DBZ");
        velocityMaxLabel = new DescriptionLabel("VELOCITY MAX");
        velocityRotationalMaxLabel = new DescriptionLabel("VELOC ROT MAX");
        velocityRotationalMeanLabel = new DescriptionLabel("VELOC ROT MEAN");
        velocityRotationalMaxClosestToGroundLabel = new DescriptionLabel("VELOC ROT MAX CL GR");

        intensityLabel = new DescriptionLabel("INTENSITY");
        intensityLabel.setFont(new Font("Courier", Font.BOLD, 12));
    }

    private void initTextFields() {
        idTextField = new DescriptionTextField();
        timeTextField = new DescriptionTextField();
        latitudeTextField = new DescriptionTextField();
        latitudeTextField.setBackground(new Color(30, 30, 30));
        longitudeTextField = new DescriptionTextField();
        longitudeTextField.setBackground(new Color(30, 30, 30));
        polarMotionTextField = new DescriptionTextField();
        majorAxisTextField = new DescriptionTextField();
        minorAxisTextField = new DescriptionTextField();
        orientationTextField = new DescriptionTextField();
        shearMeanTextField = new DescriptionTextField();
        shearMaxTextField = new DescriptionTextField();
        momentumMeanTextField = new DescriptionTextField();
        momentumMaxTextField = new DescriptionTextField();
        diameterTextField = new DescriptionTextField();
        diameterEquivalentTextField = new DescriptionTextField();
        topTextField = new DescriptionTextField();
        baseTextField = new DescriptionTextField();
        echotopTextField = new DescriptionTextField();
        vilTextField = new DescriptionTextField();
        shearVectorsTextField = new DescriptionTextField();
        shearFeaturesTextField = new DescriptionTextField();
        elevationsTextField = new DescriptionTextField();
        elevationsTextField.setSize(50, 40);
        meanDBZTextField = new DescriptionTextField();
        maxDBZTextField = new DescriptionTextField();
        velocityMaxTextField = new DescriptionTextField();
        velocityRotationalMaxTextField = new DescriptionTextField();
        velocityRotationalMeanTextField = new DescriptionTextField();
        velocityRotationalMaxClosestToGroundTextField = new DescriptionTextField();

        intensityTextField = new DescriptionTextField();
        intensityTextField.setBackground(Color.YELLOW);
        intensityTextField.setDisabledTextColor(Color.BLACK);
    }

    private void initButtons() {
        loadButton = new StandardButton("LOAD DATA");
        exitButton = new StandardButton("EXIT");
    }

    private void fillDataOfMeso(int index) {
        if (mesocyclones != null && mesocyclones.length != 0) {
            int i = index - 1;

            this.idTextField.setText(String.valueOf(mesocyclones[i].getId()));
            this.timeTextField.setText(String.valueOf(mesocyclones[i].getTime()));
            this.latitudeTextField.setText(String.valueOf(mesocyclones[i].getLatitude()));
            this.longitudeTextField.setText(String.valueOf(mesocyclones[i].getLongitude()));
            this.polarMotionTextField.setText(String.valueOf(mesocyclones[i].getPolarMotion()));
            this.majorAxisTextField.setText(String.valueOf(mesocyclones[i].getMajorAxis()));
            this.minorAxisTextField.setText(String.valueOf(mesocyclones[i].getMinorAxis()));
            this.orientationTextField.setText(String.valueOf(mesocyclones[i].getOrientation()));
            this.shearMeanTextField.setText(String.valueOf(mesocyclones[i].getShearMean()));
            this.shearMaxTextField.setText(String.valueOf(mesocyclones[i].getShearMax()));
            this.momentumMeanTextField.setText(String.valueOf(mesocyclones[i].getMomentumMean()));
            this.momentumMaxTextField.setText(String.valueOf(mesocyclones[i].getMomentumMax()));
            this.diameterTextField.setText(String.valueOf(mesocyclones[i].getDiameter()));
            this.diameterEquivalentTextField.setText(String.valueOf(mesocyclones[i].getDiameterEquivalent()));
            this.topTextField.setText(String.valueOf(mesocyclones[i].getTop()));
            this.baseTextField.setText(String.valueOf(mesocyclones[i].getBase()));
            this.echotopTextField.setText(String.valueOf(mesocyclones[i].getEchotop()));
            this.vilTextField.setText(String.valueOf(mesocyclones[i].getVil()));
            this.shearVectorsTextField.setText(String.valueOf(mesocyclones[i].getShearVectors()));
            this.shearFeaturesTextField.setText(String.valueOf(mesocyclones[i].getShearFeatures()));
            this.elevationsTextField.setText(String.valueOf(mesocyclones[i].getElevations()));
            this.meanDBZTextField.setText(String.valueOf(mesocyclones[i].getMeanDBZ()));
            this.maxDBZTextField.setText(String.valueOf(mesocyclones[i].getMaxDBZ()));
            this.velocityMaxTextField.setText(String.valueOf(mesocyclones[i].getVelocityMax()));
            this.velocityRotationalMaxTextField.setText(String.valueOf(mesocyclones[i].getVelocityRotationalMax()));
            this.velocityRotationalMeanTextField.setText(String.valueOf(mesocyclones[i].getVelocityRotationalMean()));
            this.velocityRotationalMaxClosestToGroundTextField.setText(String.valueOf(mesocyclones[i].getVelocityRotationalMaxClosestToGround()));
            this.intensityTextField.setText(String.valueOf(mesocyclones[i].getIntensity()));
        }
        else {
            System.out.println("No mesocyclones found!");
        }
    }

    private void downloadData() {
        parentWindow.downloadData();
        this.mesocyclones = parentWindow.getMesocyclones();
        this.radarStationList = parentWindow.getRadarStationList();

        navigationPanel.initMesoCount(mesocyclones.length);
        navigationPanel.updateLabel();
        mesoCurrent = 1;
    }

    public void mesoUp() {
        if (mesoCurrent == mesocyclones.length) {
            mesoCurrent = 1;
        }
        else {
            mesoCurrent++;
        }

        fillDataOfMeso(mesoCurrent);
    }

    public void mesoDown() {
        if (mesoCurrent == 1) {
            mesoCurrent = mesocyclones.length;
        }
        else {
            mesoCurrent--;
        }

        fillDataOfMeso(mesoCurrent);
    }

    public void reload() {
        downloadData();
        fillDataOfMeso(mesoCurrent);
        radarStationPanel.setRadarStationList(radarStationList);
        radarStationPanel.setColors();
        parentWindow.mapPanel.loadMesocyclonesToMap();
    }


    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == loadButton) {
                reload();
            }
            if (actionEvent.getSource() == exitButton) {
                parentWindow.setVisible(false);
                parentWindow.dispose();
            }
        }
    }

    public HeaderLabel getHeader() {
        return header;
    }

    public void setHeader(HeaderLabel header) {
        this.header = header;
    }

    public DescriptionLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(DescriptionLabel idLabel) {
        this.idLabel = idLabel;
    }

    public DescriptionLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(DescriptionLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public DescriptionLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    public void setLatitudeLabel(DescriptionLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    public DescriptionLabel getLongituteLabel() {
        return longituteLabel;
    }

    public void setLongituteLabel(DescriptionLabel longituteLabel) {
        this.longituteLabel = longituteLabel;
    }

    public DescriptionLabel getPolarMotionLabel() {
        return polarMotionLabel;
    }

    public void setPolarMotionLabel(DescriptionLabel polarMotionLabel) {
        this.polarMotionLabel = polarMotionLabel;
    }

    public DescriptionLabel getMajorAxisLabel() {
        return majorAxisLabel;
    }

    public void setMajorAxisLabel(DescriptionLabel majorAxisLabel) {
        this.majorAxisLabel = majorAxisLabel;
    }

    public DescriptionLabel getMinorAxisLabel() {
        return minorAxisLabel;
    }

    public void setMinorAxisLabel(DescriptionLabel minorAxisLabel) {
        this.minorAxisLabel = minorAxisLabel;
    }

    public DescriptionLabel getOrientationLabel() {
        return orientationLabel;
    }

    public void setOrientationLabel(DescriptionLabel orientationLabel) {
        this.orientationLabel = orientationLabel;
    }

    public DescriptionLabel getShearMeanLabel() {
        return shearMeanLabel;
    }

    public void setShearMeanLabel(DescriptionLabel shearMeanLabel) {
        this.shearMeanLabel = shearMeanLabel;
    }

    public DescriptionLabel getShearMaxLabel() {
        return shearMaxLabel;
    }

    public void setShearMaxLabel(DescriptionLabel shearMaxLabel) {
        this.shearMaxLabel = shearMaxLabel;
    }

    public DescriptionLabel getMomentumMeanLabel() {
        return momentumMeanLabel;
    }

    public void setMomentumMeanLabel(DescriptionLabel momentumMeanLabel) {
        this.momentumMeanLabel = momentumMeanLabel;
    }

    public DescriptionLabel getMomentumMaxLabel() {
        return momentumMaxLabel;
    }

    public void setMomentumMaxLabel(DescriptionLabel momentumMaxLabel) {
        this.momentumMaxLabel = momentumMaxLabel;
    }

    public DescriptionLabel getDiameterLabel() {
        return diameterLabel;
    }

    public void setDiameterLabel(DescriptionLabel diameterLabel) {
        this.diameterLabel = diameterLabel;
    }

    public DescriptionLabel getDiameterEquivalentLabel() {
        return diameterEquivalentLabel;
    }

    public void setDiameterEquivalentLabel(DescriptionLabel diameterEquivalentLabel) {
        this.diameterEquivalentLabel = diameterEquivalentLabel;
    }

    public DescriptionLabel getTopLabel() {
        return topLabel;
    }

    public void setTopLabel(DescriptionLabel topLabel) {
        this.topLabel = topLabel;
    }

    public DescriptionLabel getBaseLabel() {
        return baseLabel;
    }

    public void setBaseLabel(DescriptionLabel baseLabel) {
        this.baseLabel = baseLabel;
    }

    public DescriptionLabel getEchotopLabel() {
        return echotopLabel;
    }

    public void setEchotopLabel(DescriptionLabel echotopLabel) {
        this.echotopLabel = echotopLabel;
    }

    public DescriptionLabel getVilLabel() {
        return vilLabel;
    }

    public void setVilLabel(DescriptionLabel vilLabel) {
        this.vilLabel = vilLabel;
    }

    public DescriptionLabel getShearVectorsLabel() {
        return shearVectorsLabel;
    }

    public void setShearVectorsLabel(DescriptionLabel shearVectorsLabel) {
        this.shearVectorsLabel = shearVectorsLabel;
    }

    public DescriptionLabel getShearFeaturesLabel() {
        return shearFeaturesLabel;
    }

    public void setShearFeaturesLabel(DescriptionLabel shearFeaturesLabel) {
        this.shearFeaturesLabel = shearFeaturesLabel;
    }

    public DescriptionLabel getElevationsLabel() {
        return elevationsLabel;
    }

    public void setElevationsLabel(DescriptionLabel elevationsLabel) {
        this.elevationsLabel = elevationsLabel;
    }

    public DescriptionLabel getMeanDBZLabel() {
        return meanDBZLabel;
    }

    public void setMeanDBZLabel(DescriptionLabel meanDBZLabel) {
        this.meanDBZLabel = meanDBZLabel;
    }

    public DescriptionLabel getMaxDBZLabel() {
        return maxDBZLabel;
    }

    public void setMaxDBZLabel(DescriptionLabel maxDBZLabel) {
        this.maxDBZLabel = maxDBZLabel;
    }

    public DescriptionLabel getVelocityMaxLabel() {
        return velocityMaxLabel;
    }

    public void setVelocityMaxLabel(DescriptionLabel velocityMaxLabel) {
        this.velocityMaxLabel = velocityMaxLabel;
    }

    public DescriptionLabel getVelocityRotationalMaxLabel() {
        return velocityRotationalMaxLabel;
    }

    public void setVelocityRotationalMaxLabel(DescriptionLabel velocityRotationalMaxLabel) {
        this.velocityRotationalMaxLabel = velocityRotationalMaxLabel;
    }

    public DescriptionLabel getVelocityRotationalMeanLabel() {
        return velocityRotationalMeanLabel;
    }

    public void setVelocityRotationalMeanLabel(DescriptionLabel velocityRotationalMeanLabel) {
        this.velocityRotationalMeanLabel = velocityRotationalMeanLabel;
    }

    public DescriptionLabel getVelocityRotationalMaxClosestToGroundLabel() {
        return velocityRotationalMaxClosestToGroundLabel;
    }

    public void setVelocityRotationalMaxClosestToGroundLabel(DescriptionLabel velocityRotationalMaxClosestToGroundLabel) {
        this.velocityRotationalMaxClosestToGroundLabel = velocityRotationalMaxClosestToGroundLabel;
    }

    public DescriptionLabel getIntensityLabel() {
        return intensityLabel;
    }

    public void setIntensityLabel(DescriptionLabel intensityLabel) {
        this.intensityLabel = intensityLabel;
    }

    public DescriptionTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(DescriptionTextField idTextField) {
        this.idTextField = idTextField;
    }

    public DescriptionTextField getTimeTextField() {
        return timeTextField;
    }

    public void setTimeTextField(DescriptionTextField timeTextField) {
        this.timeTextField = timeTextField;
    }

    public DescriptionTextField getLatitudeTextField() {
        return latitudeTextField;
    }

    public void setLatitudeTextField(DescriptionTextField latitudeTextField) {
        this.latitudeTextField = latitudeTextField;
    }

    public DescriptionTextField getLongitudeTextField() {
        return longitudeTextField;
    }

    public void setLongitudeTextField(DescriptionTextField longitudeTextField) {
        this.longitudeTextField = longitudeTextField;
    }

    public DescriptionTextField getPolarMotionTextField() {
        return polarMotionTextField;
    }

    public void setPolarMotionTextField(DescriptionTextField polarMotionTextField) {
        this.polarMotionTextField = polarMotionTextField;
    }

    public DescriptionTextField getMajorAxisTextField() {
        return majorAxisTextField;
    }

    public void setMajorAxisTextField(DescriptionTextField majorAxisTextField) {
        this.majorAxisTextField = majorAxisTextField;
    }

    public DescriptionTextField getMinorAxisTextField() {
        return minorAxisTextField;
    }

    public void setMinorAxisTextField(DescriptionTextField minorAxisTextField) {
        this.minorAxisTextField = minorAxisTextField;
    }

    public DescriptionTextField getOrientationTextField() {
        return orientationTextField;
    }

    public void setOrientationTextField(DescriptionTextField orientationTextField) {
        this.orientationTextField = orientationTextField;
    }

    public DescriptionTextField getShearMeanTextField() {
        return shearMeanTextField;
    }

    public void setShearMeanTextField(DescriptionTextField shearMeanTextField) {
        this.shearMeanTextField = shearMeanTextField;
    }

    public DescriptionTextField getShearMaxTextField() {
        return shearMaxTextField;
    }

    public void setShearMaxTextField(DescriptionTextField shearMaxTextField) {
        this.shearMaxTextField = shearMaxTextField;
    }

    public DescriptionTextField getMomentumMeanTextField() {
        return momentumMeanTextField;
    }

    public void setMomentumMeanTextField(DescriptionTextField momentumMeanTextField) {
        this.momentumMeanTextField = momentumMeanTextField;
    }

    public DescriptionTextField getMomentumMaxTextField() {
        return momentumMaxTextField;
    }

    public void setMomentumMaxTextField(DescriptionTextField momentumMaxTextField) {
        this.momentumMaxTextField = momentumMaxTextField;
    }

    public DescriptionTextField getDiameterTextField() {
        return diameterTextField;
    }

    public void setDiameterTextField(DescriptionTextField diameterTextField) {
        this.diameterTextField = diameterTextField;
    }

    public DescriptionTextField getDiameterEquivalentTextField() {
        return diameterEquivalentTextField;
    }

    public void setDiameterEquivalentTextField(DescriptionTextField diameterEquivalentTextField) {
        this.diameterEquivalentTextField = diameterEquivalentTextField;
    }

    public DescriptionTextField getTopTextField() {
        return topTextField;
    }

    public void setTopTextField(DescriptionTextField topTextField) {
        this.topTextField = topTextField;
    }

    public DescriptionTextField getBaseTextField() {
        return baseTextField;
    }

    public void setBaseTextField(DescriptionTextField baseTextField) {
        this.baseTextField = baseTextField;
    }

    public DescriptionTextField getEchotopTextField() {
        return echotopTextField;
    }

    public void setEchotopTextField(DescriptionTextField echotopTextField) {
        this.echotopTextField = echotopTextField;
    }

    public DescriptionTextField getVilTextField() {
        return vilTextField;
    }

    public void setVilTextField(DescriptionTextField vilTextField) {
        this.vilTextField = vilTextField;
    }

    public DescriptionTextField getShearVectorsTextField() {
        return shearVectorsTextField;
    }

    public void setShearVectorsTextField(DescriptionTextField shearVectorsTextField) {
        this.shearVectorsTextField = shearVectorsTextField;
    }

    public DescriptionTextField getShearFeaturesTextField() {
        return shearFeaturesTextField;
    }

    public void setShearFeaturesTextField(DescriptionTextField shearFeaturesTextField) {
        this.shearFeaturesTextField = shearFeaturesTextField;
    }

    public DescriptionTextField getElevationsTextField() {
        return elevationsTextField;
    }

    public void setElevationsTextField(DescriptionTextField elevationsTextField) {
        this.elevationsTextField = elevationsTextField;
    }

    public DescriptionTextField getMeanDBZTextField() {
        return meanDBZTextField;
    }

    public void setMeanDBZTextField(DescriptionTextField meanDBZTextField) {
        this.meanDBZTextField = meanDBZTextField;
    }

    public DescriptionTextField getMaxDBZTextField() {
        return maxDBZTextField;
    }

    public void setMaxDBZTextField(DescriptionTextField maxDBZTextField) {
        this.maxDBZTextField = maxDBZTextField;
    }

    public DescriptionTextField getVelocityMaxTextField() {
        return velocityMaxTextField;
    }

    public void setVelocityMaxTextField(DescriptionTextField velocityMaxTextField) {
        this.velocityMaxTextField = velocityMaxTextField;
    }

    public DescriptionTextField getVelocityRotationalMaxTextField() {
        return velocityRotationalMaxTextField;
    }

    public void setVelocityRotationalMaxTextField(DescriptionTextField velocityRotationalMaxTextField) {
        this.velocityRotationalMaxTextField = velocityRotationalMaxTextField;
    }

    public DescriptionTextField getVelocityRotationalMeanTextField() {
        return velocityRotationalMeanTextField;
    }

    public void setVelocityRotationalMeanTextField(DescriptionTextField velocityRotationalMeanTextField) {
        this.velocityRotationalMeanTextField = velocityRotationalMeanTextField;
    }

    public DescriptionTextField getVelocityRotationalMaxClosestToGroundTextField() {
        return velocityRotationalMaxClosestToGroundTextField;
    }

    public void setVelocityRotationalMaxClosestToGroundTextField(DescriptionTextField velocityRotationalMaxClosestToGroundTextField) {
        this.velocityRotationalMaxClosestToGroundTextField = velocityRotationalMaxClosestToGroundTextField;
    }

    public DescriptionTextField getIntensityTextField() {
        return intensityTextField;
    }

    public void setIntensityTextField(DescriptionTextField intensityTextField) {
        this.intensityTextField = intensityTextField;
    }

    public StandardButton getLoadButton() {
        return loadButton;
    }

    public void setLoadButton(StandardButton loadButton) {
        this.loadButton = loadButton;
    }

    public StandardButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(StandardButton exitButton) {
        this.exitButton = exitButton;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public MainWindow getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(MainWindow parentWindow) {
        this.parentWindow = parentWindow;
    }

    public RadarStationPanel getRadarStationPanel() {
        return radarStationPanel;
    }

    public void setRadarStationPanel(RadarStationPanel radarStationPanel) {
        this.radarStationPanel = radarStationPanel;
    }

    public InfoNavigationPanel getNavigationPanel() {
        return navigationPanel;
    }

    public void setNavigationPanel(InfoNavigationPanel navigationPanel) {
        this.navigationPanel = navigationPanel;
    }

    @Override
    public Border getBorder() {
        return border;
    }

    @Override
    public void setBorder(Border border) {
        this.border = border;
    }

    public XMLFetcher getXmlFetcher() {
        return xmlFetcher;
    }

    public void setXmlFetcher(XMLFetcher xmlFetcher) {
        this.xmlFetcher = xmlFetcher;
    }

    public OpenDataReader getOdr() {
        return odr;
    }

    public void setOdr(OpenDataReader odr) {
        this.odr = odr;
    }

    public Mesocyclone[] getMesocyclones() {
        return mesocyclones;
    }

    public void setMesocyclones(Mesocyclone[] mesocyclones) {
        this.mesocyclones = mesocyclones;
    }

    public List<RadarStation> getRadarStationList() {
        return radarStationList;
    }

    public void setRadarStationList(List<RadarStation> radarStationList) {
        this.radarStationList = radarStationList;
    }

    public int getMesoCurrent() {
        return mesoCurrent;
    }

    public void setMesoCurrent(int mesoCurrent) {
        this.mesoCurrent = mesoCurrent;
    }
}
