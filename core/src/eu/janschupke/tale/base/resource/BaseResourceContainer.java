package eu.janschupke.tale.base.resource;

import eu.janschupke.tale.base.App;

/**
 * Base class for resource containers.
 * Provides common functionality for resource management.
 */
public abstract class BaseResourceContainer {
    protected final App app;

    public BaseResourceContainer(final App app) {
        this.app = app;
    }

    public abstract void dispose();
}
