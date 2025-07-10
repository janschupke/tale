package io.schupke.tale.base.ui;

/**
 * Defines general methods that all interaction-capable user interface
 * classes must implement.
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
