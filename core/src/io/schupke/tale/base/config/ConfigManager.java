package io.schupke.tale.base.config;

/**
 * Manages application configuration and settings.
 * Handles loading, saving, and accessing configuration data.
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
