package eu.janschupke.buddy.framework.base.ui;

/**
 * Defines general methods that all interaction-capable user interface
 * classes must implement.
 */
public interface UserInterface {
    void initWidgets();
    void addWidgets();
    void setListeners();
}
