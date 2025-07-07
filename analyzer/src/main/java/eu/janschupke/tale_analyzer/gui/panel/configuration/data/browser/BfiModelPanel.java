package eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser;

import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiQuestion;
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
 * Overview panel for the BFI calculation model.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiModelPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(BfiModelPanel.class.getName());
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.overview.bfi.table.number"));
        names.add(Lang.write("main.tab.overview.bfi.table.description"));
        names.add(Lang.write("main.tab.overview.bfi.table.trait"));
        names.add(Lang.write("main.tab.overview.bfi.table.reverse"));
    }

    public BfiModelPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating BFI model table");
        logger.log(Level.INFO, String.format("Amount of questions: %d",
                mainWindow.getAnalyzer().getModel().getBfiModel().getQuestions().size()));

        BfiModel bfiModel = mainWindow.getAnalyzer().getModel().getBfiModel();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        for (BfiQuestion question : bfiModel.getQuestions()) {
            Vector<Object> row = new Vector<>();
            row.add(question.getNumber());
            row.add(question.getDescription());
            row.add(question.getTrait());
            row.add(question.isReverse());
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
