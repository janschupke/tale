package eu.janschupke.tale_analyzer.gui.menu;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.UserInterface;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;

/**
 * Main submenu.
 *
 * @author jan.schupke@gmail.com
 */
public class MainMenu extends JMenu implements UserInterface {
    private MainWindow mainWindow;

    private JMenuItem clearMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exportMenuItem;
    private JMenuItem exitMenuItem;

    public MainMenu(MainWindow mainWindow, String title) {
        super(title);
        this.mainWindow = mainWindow;
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        String title;

        title = Lang.write("menu.main.clear");
        clearMenuItem = new JMenuItem(title);

        title = Lang.write("menu.main.save");
        saveMenuItem = new JMenuItem(title);

        title = Lang.write("menu.main.export");
        exportMenuItem = new JMenuItem(title);

        title = Lang.write("menu.main.exit");
        exitMenuItem = new JMenuItem(title);
    }

    @Override
    public void addWidgets() {
        add(clearMenuItem);
        add(saveMenuItem);
        add(exportMenuItem);
        add(exitMenuItem);
    }

    @Override
    public void setListeners() {
        clearMenuItem.addActionListener(e -> {
            mainWindow.getAnalyzer().getEventHandler().clearData();
        });
        saveMenuItem.addActionListener(e -> {
            mainWindow.getAnalyzer().getEventHandler().saveState();
        });
        exportMenuItem.addActionListener(e -> {
            mainWindow.getAnalyzer().getEventHandler().invokeExport();
        });
        exitMenuItem.addActionListener(e -> {
            mainWindow.getAnalyzer().getEventHandler().exitApplication();
        });
    }
}
