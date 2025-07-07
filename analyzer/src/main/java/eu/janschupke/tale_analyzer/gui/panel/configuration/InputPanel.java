package eu.janschupke.tale_analyzer.gui.panel.configuration;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.gui.panel.Subpanel;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Inner panel of the configuration tab. Contains file choosers.
 *
 * @author jan.schupke@gmail.com
 */
public class InputPanel extends Subpanel implements Observer {
    private JPanel chooserPanel;

    private JButton gameModelOpenButton;
    private JButton bfiModelOpenButton;
    private JButton dataFolderOpenButton;

    private JTextField gameModelField;
    private JTextField bfiModelField;
    private JTextField dataFolderField;

    private JButton calculateButton;

    private JFileChooser gameModelChooser;
    private JFileChooser bfiModelChooser;
    private JFileChooser dataFolderChooser;

    public InputPanel(MainWindow mainWindow) {
        super(mainWindow);
        setTooltips();
    }

    private void setTooltips() {
//        Behavior.setTooltip(calculateButton, Lang.write("main.tab.config.input.button.calculate.tooltip"), mainWindow.getStatusBar());
    }

    @Override
    public void initWidgets() {
        chooserPanel = new JPanel();
        gameModelOpenButton = new JButton(Lang.write("main.tab.config.input.button.game-model"));
        bfiModelOpenButton = new JButton(Lang.write("main.tab.config.input.button.bfi-model"));
        dataFolderOpenButton = new JButton(Lang.write("main.tab.config.input.button.data-folder"));

        calculateButton = new JButton(Lang.write("main.tab.config.input.button.calculate"));

        gameModelField = new JTextField();
        gameModelField.setEditable(false);
        bfiModelField = new JTextField();
        bfiModelField.setEditable(false);
        dataFolderField = new JTextField();
        dataFolderField.setEditable(false);

        gameModelChooser = new JFileChooser(mainWindow.getAnalyzer().getModel().getInputState().getGameModelPath());
        gameModelChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        bfiModelChooser = new JFileChooser(mainWindow.getAnalyzer().getModel().getInputState().getBfiModelPath());
        bfiModelChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dataFolderChooser = new JFileChooser(mainWindow.getAnalyzer().getModel().getInputState().getDataFolderPath());
        dataFolderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(chooserPanel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);

        chooserPanel.setLayout(new GridLayout(3, 2));
        chooserPanel.add(gameModelOpenButton);
        chooserPanel.add(gameModelField);
        chooserPanel.add(bfiModelOpenButton);
        chooserPanel.add(bfiModelField);
        chooserPanel.add(dataFolderOpenButton);
        chooserPanel.add(dataFolderField);
    }

    @Override
    public void update(Observable o, Object arg) {
        String path;

        path = mainWindow.getAnalyzer().getModel().getInputState().getGameModelPath();
        gameModelField.setText(path);
        gameModelChooser.setCurrentDirectory(new File(path));

        path = mainWindow.getAnalyzer().getModel().getInputState().getBfiModelPath();
        bfiModelField.setText(path);
        bfiModelChooser.setCurrentDirectory(new File(path));

        path = mainWindow.getAnalyzer().getModel().getInputState().getDataFolderPath();
        dataFolderField.setText(path);
        dataFolderChooser.setCurrentDirectory(new File(path));
    }

    @Override
    public void setListeners() {
        gameModelOpenButton.addActionListener(e -> {
            int value = gameModelChooser.showOpenDialog(this);
            if (value == JFileChooser.APPROVE_OPTION) {
                String path = gameModelChooser.getSelectedFile().getAbsolutePath();
                mainWindow.getAnalyzer().getEventHandler().loadGameModel(path);
                mainWindow.getAnalyzer().getModel().getInputState().setGameModelPath(path);
            }
        });
        bfiModelOpenButton.addActionListener(e -> {
            int value = bfiModelChooser.showOpenDialog(this);
            if (value == JFileChooser.APPROVE_OPTION) {
                String path = bfiModelChooser.getSelectedFile().getAbsolutePath();
                mainWindow.getAnalyzer().getEventHandler().loadBfiModel(path);
                mainWindow.getAnalyzer().getModel().getInputState().setBfiModelPath(path);
            }
        });
        dataFolderOpenButton.addActionListener(e -> {
            int value = dataFolderChooser.showOpenDialog(this);
            if (value == JFileChooser.APPROVE_OPTION) {
                String path = dataFolderChooser.getSelectedFile().getAbsolutePath();
                mainWindow.getAnalyzer().getEventHandler().loadData(path);
                mainWindow.getAnalyzer().getModel().getInputState().setDataFolderPath(path);
            }
        });
        calculateButton.addActionListener(e -> {
            mainWindow.getAnalyzer().getEventHandler().calculate();
        });
    }
}
