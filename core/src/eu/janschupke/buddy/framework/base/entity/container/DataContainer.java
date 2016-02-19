package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

/**
 * Base superclass for all data containers.
 * @author jan.schupke@gmail.com
 */
public abstract class DataContainer {
    protected App app;

    public DataContainer(final App app) {
        this.app = app;
    }
}
