package eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser;

import eu.janschupke.tale_analyzer.entity.measurement.data.EventSummary;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration panel that displays event summary for given dataset.
 *
 * @author jan.schupke@gmail.com
 */
public class SummaryPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(PlaythroughPanel.class.getName());
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.config.data.browser.summary.table.tag"));
        names.add(Lang.write("main.tab.config.data.browser.summary.table.count"));
    }

    public SummaryPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating summary table");

        EventSummary eventSummary = mainWindow.getAnalyzer().getModel().getEventSummary();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        for (HashMap.Entry entry : eventSummary.getEvents().entrySet()) {
            String tag = (String) entry.getKey();
            int count = (int) entry.getValue();
            Vector<Object> row = new Vector<>();
            row.add(tag);
            row.add(count);
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
