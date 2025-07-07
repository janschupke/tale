package eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser;

import eu.janschupke.tale_analyzer.entity.measurement.data.Playthrough;
import eu.janschupke.tale_analyzer.entity.measurement.data.PlaythroughEvent;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration panel that displays user's playthrough based on provided data.
 *
 * @author jan.schupke@gmail.com
 */
public class PlaythroughPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(PlaythroughPanel.class.getName());
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.config.data.browser.playthrough.table.time"));
        names.add(Lang.write("main.tab.config.data.browser.playthrough.table.level"));
        names.add(Lang.write("main.tab.config.data.browser.playthrough.table.tag"));
    }

    public PlaythroughPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating playthrough table");

        // No data are available.
        if (mainWindow.getAnalyzer().getModel().getDataSelection().getActiveDataSet() == null) {
            DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            return;
        }

        logger.log(Level.INFO, String.format("Amount of entries: %d",
                mainWindow.getAnalyzer().getModel().getDataSelection().getActiveDataSet().getPlaythrough().getEvents().size()));

        Playthrough playthrough = mainWindow.getAnalyzer().getModel().getDataSelection().getActiveDataSet().getPlaythrough();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        for (PlaythroughEvent playthroughEvent : playthrough.getEvents()) {
            Vector<Object> row = new Vector<>();
            row.add(playthroughEvent.getTimestamp());
            row.add(playthroughEvent.getLevel());
            row.add(playthroughEvent.getTag());
            data.add(row);
        }

        tableModel.setDataVector(data, names);
        tableModel.fireTableDataChanged();
    }

    @Override
    public void initWidgets() {
        modelTable = new JTable(null, names) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelTable.setDragEnabled(false);
        tableScrollPane = new JScrollPane(modelTable);
        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(tableScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void setListeners() {

    }
}
