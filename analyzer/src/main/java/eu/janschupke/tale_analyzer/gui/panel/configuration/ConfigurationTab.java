package eu.janschupke.tale_analyzer.gui.panel.configuration;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;

import java.awt.*;

/**
 * GUI tab for the configuration mode.
 *
 * @author jan.schupke@gmail.com
 */
public class ConfigurationTab extends Subpanel {
    private InputPanel inputPanel;
    private DataPanel dataPanel;

    public ConfigurationTab(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void initWidgets() {
        inputPanel = new InputPanel(mainWindow);
        dataPanel = new DataPanel(mainWindow);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(dataPanel, BorderLayout.CENTER);
    }

    @Override
    public void setListeners() {

    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public DataPanel getDataPanel() {
        return dataPanel;
    }
}
