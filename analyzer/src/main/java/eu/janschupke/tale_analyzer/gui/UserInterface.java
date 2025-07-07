package eu.janschupke.tale_analyzer.gui;

/**
 * Common interface of all widget containers.
 *
 * @author jan.schupke@gmail.com
 */
public interface UserInterface {
    /**
     * Initiates all widgets within the UI container.
     */
    void initWidgets();

    /**
     * Adds all widgets to the display area.
     */
    void addWidgets();

    /**
     * Sets listeners for all widgets that require it.
     */
    void setListeners();
}
