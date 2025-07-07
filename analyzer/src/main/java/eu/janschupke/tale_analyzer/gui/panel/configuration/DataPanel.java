package eu.janschupke.tale_analyzer.gui.panel.configuration;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.BrowserPanel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Inner panel of the configuration tab. Contains data panels.
 *
 * @author jan.schupke@gmail.com
 */
public class DataPanel extends Subpanel {
    private BrowserPanel browserPanel;

    public DataPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void initWidgets() {
        browserPanel = new BrowserPanel(mainWindow);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(browserPanel, BorderLayout.CENTER);
    }

    @Override
    public void setListeners() {

    }

    public BrowserPanel getBrowserPanel() {
        return browserPanel;
    }
}
