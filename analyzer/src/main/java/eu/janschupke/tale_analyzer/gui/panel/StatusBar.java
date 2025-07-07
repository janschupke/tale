package eu.janschupke.tale_analyzer.gui.panel;

import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.language.Lang;

import javax.swing.*;
import java.awt.*;

/**
 * Bottom status bar GUI.
 *
 * @author jan.schupke@gmail.com
 */
public class StatusBar extends Subpanel {
    private JLabel statusLabel;

    public StatusBar(MainWindow mainWindow) {
        super(mainWindow);
    }

    @Override
    public void initWidgets() {
        statusLabel = new JLabel();
        statusLabel.setText(Lang.write("main.status.label"));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void addWidgets() {
        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.CENTER);
    }

    @Override
    public void setListeners() {

    }
}
