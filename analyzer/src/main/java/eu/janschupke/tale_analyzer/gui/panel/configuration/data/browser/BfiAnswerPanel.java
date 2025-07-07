package eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser;

import eu.janschupke.tale_analyzer.entity.measurement.data.BfiAnswers;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
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
 * Configuration panel that displays BFI results for given dataset.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiAnswerPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(PlaythroughPanel.class.getName());
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.config.data.browser.bfi-answers.table.number"));
        names.add(Lang.write("main.tab.config.data.browser.bfi-answers.table.description"));
        names.add(Lang.write("main.tab.config.data.browser.bfi-answers.table.answer"));
    }

    public BfiAnswerPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating BFI answer table");

        // No data are available.
        if (mainWindow.getAnalyzer().getModel().getDataSelection().getActiveDataSet() == null) {
            DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            return;
        }

        BfiAnswers bfiAnswers = mainWindow.getAnalyzer().getModel().getDataSelection().getActiveDataSet().getBfiAnswers();
        BfiModel bfiModel = mainWindow.getAnalyzer().getModel().getBfiModel();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        for (int i = 0; i < bfiAnswers.getAnswers().size(); i++) {
            Vector<Object> row = new Vector<>();
            row.add(bfiModel.getQuestions().get(i).getNumber());
            row.add(bfiModel.getQuestions().get(i).getDescription());
            row.add(bfiAnswers.getAnswers().get(i));
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
