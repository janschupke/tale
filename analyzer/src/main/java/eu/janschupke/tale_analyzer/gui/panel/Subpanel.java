package eu.janschupke.tale_analyzer.gui.panel;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.UserInterface;

import javax.swing.*;

/**
 * Parent of all GUI panels.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Subpanel extends JPanel implements UserInterface {
    protected MainWindow mainWindow;

    public Subpanel(final MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initWidgets();
        addWidgets();
        setListeners();
    }
}
