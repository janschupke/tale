package eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser;

import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventModel;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.BfiModelPanel;
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
 * Overview panel for the Game Event model.
 *
 * @author jan.schupke@gmail.com
 */
public class GameModelPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(BfiModelPanel.class.getName());
    private JScrollPane tableScrollPane;
    private JTable modelTable;
    public static final Vector<String> names = new Vector<>();

    static {
        names.add(Lang.write("main.tab.overview.game.table.tag"));
        names.add(Lang.write("main.tab.overview.game.table.description"));
    }

    public GameModelPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating game model table");
        logger.log(Level.INFO, String.format("Amount of events: %d",
                mainWindow.getAnalyzer().getModel().getGameEventModel().getEvents().size()));

        GameEventModel gameEventModel = mainWindow.getAnalyzer().getModel().getGameEventModel();
        Vector<Vector<Object>> data = new Vector<>();

        DefaultTableModel tableModel = (DefaultTableModel)modelTable.getModel();
        tableModel.getDataVector().removeAllElements();

        for (GameEvent gameEvent : gameEventModel.getEvents()) {
            Vector<Object> row = new Vector<>();
            row.add(gameEvent.getTag());
            row.add(gameEvent.getDescription());
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
