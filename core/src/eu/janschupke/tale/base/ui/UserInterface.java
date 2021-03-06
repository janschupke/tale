package eu.janschupke.tale.base.ui;

/**
 * Defines general methods that all interaction-capable user interface
 * classes must implement.
 *
 * @author jan.schupke@gmail.com
 */
public interface UserInterface {
    /**
     * Initiates instances of all used widgets.
     */
    void initWidgets();

    /**
     * Adds all initiated widgets onto the parent.
     */
    void addWidgets();

    /**
     * Sets listeners for all widgets that require one.
     */
    void setListeners();
}
