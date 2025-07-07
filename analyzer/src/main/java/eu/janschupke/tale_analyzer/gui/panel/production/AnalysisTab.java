package eu.janschupke.tale_analyzer.gui.panel.production;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.gui.panel.production.tabs.EventGroupTab;
import eu.janschupke.tale_analyzer.gui.panel.production.tabs.MatrixTab;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * GUI tab for the production analysis mode.
 *
 * @author jan.schupke@gmail.com
 */
public class AnalysisTab extends Subpanel implements Observer {
    private JTabbedPane analysisTabbedPane;
    private MatrixTab matrixTab;
    private EventGroupTab eventGroupTab;


    public AnalysisTab(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    @Override
    public void initWidgets() {
        analysisTabbedPane = new JTabbedPane();
        matrixTab = new MatrixTab(mainWindow);
        eventGroupTab = new EventGroupTab(mainWindow);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(analysisTabbedPane, BorderLayout.CENTER);

        analysisTabbedPane.add(Lang.write("analysis.tab.matrix.title"), matrixTab);
        analysisTabbedPane.add(Lang.write("analysis.tab.group.title"), eventGroupTab);
    }

    @Override
    public void setListeners() {
    }

    public MatrixTab getMatrixTab() {
        return matrixTab;
    }

    public EventGroupTab getEventGroupTab() {
        return eventGroupTab;
    }
}
