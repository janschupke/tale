package eu.janschupke.tale_analyzer.gui;

import eu.janschupke.tale_analyzer.Analyzer;
import eu.janschupke.tale_analyzer.config.Config;
import eu.janschupke.tale_analyzer.gui.menu.MainMenuBar;
import eu.janschupke.tale_analyzer.gui.panel.StatusBar;
import eu.janschupke.tale_analyzer.gui.panel.configuration.ConfigurationTab;
import eu.janschupke.tale_analyzer.gui.panel.production.AnalysisTab;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main GUI window.
 *
 * @author jan.schupke@gmail.com
 */
public class MainWindow extends JFrame implements UserInterface {
    private final static Logger logger = Logger.getLogger(MainWindow.class.getName());

    private Analyzer analyzer;

    private MainMenuBar mainMenuBar;

    private JTabbedPane tabbedPane;
    private ConfigurationTab configurationTab;
    private AnalysisTab analysisTab;

    private StatusBar statusBar;

    private JFileChooser exportChooser;

    public MainWindow(final Analyzer analyzer) {
        this.analyzer = analyzer;
        configureWindow();
        initWidgets();
        addWidgets();
        setListeners();
        assignObservers();
    }

    /**
     * Assigns GUI observers to all necessary model objects.
     */
    private void assignObservers() {
        analyzer.getModel().getBfiModel().addObserver(configurationTab.getDataPanel().getBrowserPanel().getBfiModelPanel());
        analyzer.getModel().getGameEventModel().addObserver(configurationTab.getDataPanel().getBrowserPanel().getGameModelPanel());

        analyzer.getModel().getInputState().addObserver(configurationTab.getInputPanel());
        analyzer.getModel().getDataSetContainer().addObserver(configurationTab.getDataPanel().getBrowserPanel());

        analyzer.getModel().getBfiResult().addObserver(configurationTab.getDataPanel().getBrowserPanel().getBfiResultPanel());
        analyzer.getModel().getDataSelection().addObserver(configurationTab.getDataPanel().getBrowserPanel().getBfiAnswerPanel());
        analyzer.getModel().getDataSelection().addObserver(configurationTab.getDataPanel().getBrowserPanel().getPlaythroughPanel());
        analyzer.getModel().getDataSelection().addObserver(configurationTab.getDataPanel().getBrowserPanel().getSummaryPanel());

        analyzer.getModel().getCorrelationResult().addObserver(analysisTab.getMatrixTab());
        analyzer.getModel().getGroupedResult().addObserver(analysisTab.getEventGroupTab());
    }

    /**
     * Performs basic Swing window configuration.
     */
    private void configureWindow() {
        setLookAndFeel();
        setTitle(Config.APP_NAME);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setMinimumSize(new Dimension(Config.WINDOW_MIN_WIDTH, Config.WINDOW_MIN_HEIGHT));
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Attempts to set Nimbus look and feel for the application window.
     */
    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Look and feel not found");
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
                logger.log(Level.WARNING, "MainWindow#setLookAndFeel - Exception: " + e.getMessage());

                System.exit(1);
            }
        }
    }

    @Override
    public void initWidgets() {
        mainMenuBar = new MainMenuBar(this);
        tabbedPane = new JTabbedPane();
        configurationTab = new ConfigurationTab(this);
        analysisTab = new AnalysisTab(this);
        statusBar = new StatusBar(this);
        exportChooser = new JFileChooser(analyzer.getModel().getInputState().getExportFolder());
        exportChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @Override
    public void addWidgets() {
        setJMenuBar(mainMenuBar);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        tabbedPane.add(Lang.write("main.tab.config.title"), configurationTab);
        tabbedPane.add(Lang.write("main.tab.analysis.title"), analysisTab);
    }

    @Override
    public void setListeners() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                analyzer.getEventHandler().exitApplication();
            }
        });
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public JFileChooser getExportChooser() {
        return exportChooser;
    }
}
