import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    private Menu fileMenu;
    private MenuItem newMenuItem, exitMenuItem;

    private Menu aboutMenu;
    private MenuItem infoMenuItem;

    private Color bg = new Color(40, 40, 40);

    public MenuBar() {
        setBackground(bg);

        fileMenu = new Menu("File");
        newMenuItem = new MenuItem("New");
        exitMenuItem = new MenuItem("Exit");

        fileMenu.add(newMenuItem);
        fileMenu.add(exitMenuItem);

        aboutMenu = new Menu("About");
        infoMenuItem = new MenuItem("Info");

        aboutMenu.add(infoMenuItem);

        add(fileMenu);
        add(aboutMenu);
    }
}
