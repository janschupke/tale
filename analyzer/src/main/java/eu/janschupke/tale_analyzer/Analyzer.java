package eu.janschupke.tale_analyzer;

import eu.janschupke.tale_analyzer.event.EventHandler;
import eu.janschupke.tale_analyzer.gui.MainWindow;
import eu.janschupke.tale_analyzer.language.Lang;
import eu.janschupke.tale_analyzer.entity.measurement.Model;

/**
 * Tale Data Analyzer main class.
 *
 * @author jan.schupke@gmail.com
 */
public class Analyzer {
    private ClassLoader classLoader;
    private MainWindow mainWindow;
    private Model model;
    private EventHandler eventHandler;

    public Analyzer() {
        classLoader = this.getClass().getClassLoader();
        model = new Model();
        eventHandler = new EventHandler(this);
        mainWindow = new MainWindow(this);
    }

    public static void main(String[] args) {
        Lang.loadLang(0);
        Analyzer analyzer = new Analyzer();
        analyzer.getEventHandler().loadState();
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public Model getModel() {
        return model;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }
}
