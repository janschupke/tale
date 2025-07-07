package eu.janschupke.tale_analyzer.gui.panel.production.tabs;

import eu.janschupke.tale_analyzer.entity.measurement.results.CorrelationResult;
import eu.janschupke.tale_analyzer.entity.measurement.results.GroupedResult;
import eu.janschupke.tale_analyzer.entity.personality.Traits;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * Tab for the event group correlations.
 *
 * @author jan.schupke@gmail.com
 */
public class EventGroupTab extends Subpanel implements Observer {
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.analysis.table.event"));
        for (Traits trait : Traits.values()) {
            names.add(trait.toString());
        }
    }

    public EventGroupTab(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        // No data are available.
        if (mainWindow.getAnalyzer().getModel().getGroupedResult().getCorrelations() == null) {
            DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            return;
        }

        GroupedResult groupedResult = mainWindow.getAnalyzer().getModel().getGroupedResult();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        // Refreshing trait headers to get them in order with the data.
        names.clear();
        names.add(Lang.write("main.tab.analysis.table.event"));
        for (Traits trait : groupedResult.getTraits()) {
            names.add(trait.toString());
        }

        for (int i = 0; i < groupedResult.getEvents().length; i++) {
            Vector<Object> row = new Vector<>();
            row.add(groupedResult.getEvents()[i].getTag());

            for (int j = 0; j < groupedResult.getTraits().length; j++) {
                row.add(String.format("%.2f", groupedResult.getCorrelations()[i][j]));
            }

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
