package eu.janschupke.tale_analyzer.gui.menu;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.UserInterface;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;

/**
 * Main menu bar.
 *
 * @author jan.schupke@gmail.com
 */
public class MainMenuBar extends JMenuBar implements UserInterface {
    private MainWindow mainWindow;

    private MainMenu mainMenu;

    public MainMenuBar(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        String title;

        title = Lang.write("menu.main.title");
        mainMenu = new MainMenu(mainWindow, title);
    }

    @Override
    public void addWidgets() {
        add(mainMenu);
    }

    @Override
    public void setListeners() {

    }
}
