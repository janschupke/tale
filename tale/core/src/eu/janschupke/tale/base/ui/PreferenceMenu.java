package eu.janschupke.tale.base.ui;

/**
 * Interface for all menu tables that contain configurable widgets.
 *
 * @author jan.schupke@gmail.com
 */
public interface PreferenceMenu {
    /**
     * Responsible for calling running config update and appropriate
     * config manager persisting methods.
     */
    void applyChanges();

    /**
     * Updates all modified running configuration values.
     */
    void updateRunningConfig();

    /**
     * Updates any currently active objects that could
     * have been affected by the configuration change.
     */
    void updateGameState();

    /**
     * Sets the widgets' values based on preferences.
     */
    void configureWidgets();
}
