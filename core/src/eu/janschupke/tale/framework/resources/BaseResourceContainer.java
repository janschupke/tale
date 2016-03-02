package eu.janschupke.tale.framework.resources;

import eu.janschupke.tale.framework.App;

/**
 * Base class for all resource containers.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class BaseResourceContainer {
    protected final App app;

    public BaseResourceContainer(final App app) {
        this.app = app;
    }

    public abstract void dispose();
}
