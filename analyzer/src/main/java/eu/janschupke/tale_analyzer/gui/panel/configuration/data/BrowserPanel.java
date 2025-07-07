package eu.janschupke.tale_analyzer.gui.panel.configuration.data;

import eu.janschupke.tale_analyzer.entity.measurement.data.DataSet;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.BfiAnswerPanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.BfiResultPanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.PlaythroughPanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.SummaryPanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.BfiModelPanel;
import eu.janschupke.tale_analyzer.gui.panel.configuration.data.browser.GameModelPanel;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration panel that encapsulates all input data presentation.
 *
 * @author jan.schupke@gmail.com
 */
public class BrowserPanel extends Subpanel implements Observer {
    private final static Logger logger = Logger.getLogger(BrowserPanel.class.getName());

    private JPanel listPanel;
    private JLabel listLabel;
    private JList<String> dataSetList;
    private JTabbedPane browserTabbedPane;
    private BfiAnswerPanel bfiAnswerPanel;
    private BfiResultPanel bfiResultPanel;
    private PlaythroughPanel playthroughPanel;
    private SummaryPanel summaryPanel;
    private BfiModelPanel bfiModelPanel;
    private GameModelPanel gameModelPanel;

    public BrowserPanel(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger.log(Level.INFO, "Updating BrowserPanel");
        logger.log(Level.INFO, String.format("Amount of DataSets: %d",
                mainWindow.getAnalyzer().getModel().getDataSetContainer().getDataSets().size()));

        Vector<String> items = new Vector<>();

        for (DataSet dataSet : mainWindow.getAnalyzer().getModel().getDataSetContainer().getDataSets()) {
            items.add(dataSet.getName());
        }

        dataSetList.setListData(items);
    }

    @Override
    public void initWidgets() {
        listPanel = new JPanel();
        listLabel = new JLabel(Lang.write("main.tab.config.data.browser.list.label"));
        dataSetList = new JList<>();
        browserTabbedPane = new JTabbedPane();
        bfiAnswerPanel = new BfiAnswerPanel(mainWindow);
        bfiResultPanel = new BfiResultPanel(mainWindow);
        playthroughPanel = new PlaythroughPanel(mainWindow);
        summaryPanel = new SummaryPanel(mainWindow);
        bfiModelPanel = new BfiModelPanel(mainWindow);
        gameModelPanel = new GameModelPanel(mainWindow);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(listPanel, BorderLayout.WEST);
        add(browserTabbedPane, BorderLayout.CENTER);

        listPanel.setLayout(new BorderLayout());
        listPanel.add(listLabel, BorderLayout.NORTH);
        listPanel.add(dataSetList, BorderLayout.CENTER);

        browserTabbedPane.add(Lang.write("main.tab.config.data.browser.bfi-answers.title"), bfiAnswerPanel);
        browserTabbedPane.add(Lang.write("main.tab.config.data.browser.bfi-result.title"), bfiResultPanel);
        browserTabbedPane.add(Lang.write("main.tab.config.data.browser.playthrough.title"), playthroughPanel);
        browserTabbedPane.add(Lang.write("main.tab.config.data.browser.summary.title"), summaryPanel);

        browserTabbedPane.add(Lang.write("main.tab.overview.bfi.title"), bfiModelPanel);
        browserTabbedPane.add(Lang.write("main.tab.overview.game.title"), gameModelPanel);
    }

    @Override
    public void setListeners() {
        dataSetList.addListSelectionListener(e -> {
            logger.log(Level.INFO, "List changed");
            mainWindow.getAnalyzer().getEventHandler().updateSelection(dataSetList.getSelectedIndex());
        });
    }

    public BfiAnswerPanel getBfiAnswerPanel() {
        return bfiAnswerPanel;
    }

    public BfiResultPanel getBfiResultPanel() {
        return bfiResultPanel;
    }

    public PlaythroughPanel getPlaythroughPanel() {
        return playthroughPanel;
    }

    public SummaryPanel getSummaryPanel() {
        return summaryPanel;
    }

    public BfiModelPanel getBfiModelPanel() {
        return bfiModelPanel;
    }

    public GameModelPanel getGameModelPanel() {
        return gameModelPanel;
    }
}
