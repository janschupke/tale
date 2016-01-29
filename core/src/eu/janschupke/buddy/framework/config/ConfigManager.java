package eu.janschupke.buddy.framework.config;

/**
 * Common interface for configuration manager classes.
 */
public interface ConfigManager {
    void persist();
    void load();
    void reset();
}
