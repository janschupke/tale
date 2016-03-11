package eu.janschupke.tale.base.config;

/**
 * Common interface for configuration manager classes.
 *
 * @author jan.schupke@gmail.com
 */
public interface ConfigManager {
    /**
     * Persists running configuration into the preference files.
     */
    void persist();

    /**
     * Loads settings from the preference files.
     */
    void load();

    /**
     * Returns all settings to default values.
     */
    void reset();
}
