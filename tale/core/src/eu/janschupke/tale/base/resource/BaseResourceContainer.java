package eu.janschupke.tale.base.resource;

import eu.janschupke.tale.base.App;

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
