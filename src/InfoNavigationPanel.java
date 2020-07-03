import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoNavigationPanel extends JPanel {
    private StandardButton leftButton, rightButton;
    private NavigationLabel navigationLabel;
    private TitledBorder border = new TitledBorder("MESO NAVIGATION");
    private Color bg = Color.GRAY;
    private Font font = new Font("Consolas", Font.BOLD, 30);
    private InformationPanel informationPanel;

    private int mesoCurrent = 0;
    private int mesoCount = 0;

    public InfoNavigationPanel() {
        border.setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(new FlowLayout());
        setBorder(border);
        setBackground(bg);

        ButtonListener buttonListener = new ButtonListener();

        leftButton = new StandardButton("<");
        rightButton = new StandardButton(">");
        leftButton.setFont(font);
        rightButton.setFont(font);
        leftButton.setPreferredSize(new Dimension(50, 50));
        rightButton.setPreferredSize(new Dimension(50, 50));

        leftButton.addActionListener(buttonListener);
        rightButton.addActionListener(buttonListener);

        navigationLabel = new NavigationLabel("---");

        add(leftButton);
        add(navigationLabel);
        add(rightButton);
    }

    public void setInformationPanel(InformationPanel informationPanel) {
        this.informationPanel = informationPanel;
    }

    public void initMesoCount(int count) {
        this.mesoCount = count;
        this.mesoCurrent = 1;
    }

    public void updateLabel() {
        String s = "MESO ";

        s += mesoCurrent + " of ";
        s += mesoCount;

        navigationLabel.setText(s);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (mesoCount != 0) {
                if (actionEvent.getSource() == leftButton) {
                    if (mesoCurrent == 1) {
                        mesoCurrent = mesoCount;
                    }
                    else {
                        mesoCurrent--;
                    }

                    updateLabel();
                    informationPanel.mesoDown();
                }

                if (actionEvent.getSource() == rightButton) {
                    if (mesoCurrent == mesoCount) {
                        mesoCurrent = 1;
                    } else {
                        mesoCurrent++;
                    }

                    updateLabel();
                    informationPanel.mesoUp();
                }
            }
        }
    }
}
