import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private StandardButton loadButton, clearButton;
    private JPanel buttonPanel;
    Border border = BorderFactory.createLoweredBevelBorder();

    List<Mesocyclone> mesocycloneList;

    public InformationPanel(List<Mesocyclone> mesocycloneList) {
        this.mesocycloneList = mesocycloneList;
        GridBagLayout gridBagLayout = new GridBagLayout();

        setLayout(gridBagLayout);
        setBackground(Color.GRAY);

        if (border!= null) {
            setBorder(border);
        }

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);

        initLabels();
        initTextFields();
        initButtons();

        ButtonListener buttonListener = new ButtonListener();

        loadButton.addActionListener(buttonListener);

        buttonPanel.add(loadButton);
        buttonPanel.add(clearButton);

        GridBagConstraints gbc = new GridBagConstraints();

        // ROW 0
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(header, gbc);

        add(Box.createVerticalStrut(50));

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

        // BUTTONROW
        gbc.gridwidth = 2;

        gbc.gridx = 0;
        gbc.gridy = 30;
        add(buttonPanel, gbc);


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
    }

    private void initTextFields() {
        idTextField = new DescriptionTextField();
        timeTextField = new DescriptionTextField();
        latitudeTextField = new DescriptionTextField();
        longitudeTextField = new DescriptionTextField();
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
    }

    private void initButtons() {
        loadButton = new StandardButton("LOAD");
        clearButton = new StandardButton("CLEAR");
    }

    private void fillData() {
        this.idTextField.setText(String.valueOf(mesocycloneList.get(0).getId()));
        this.timeTextField.setText(String.valueOf(mesocycloneList.get(0).getTime()));
        this.latitudeTextField.setText(String.valueOf(mesocycloneList.get(0).getLatitude()));
        this.longitudeTextField.setText(String.valueOf(mesocycloneList.get(0).getLongitude()));
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == loadButton) {
                fillData();
            }
        }
    }
}
