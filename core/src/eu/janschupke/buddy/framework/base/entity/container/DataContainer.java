package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

import java.util.Observable;

/**
 * Base superclass for all data containers.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class DataContainer extends Observable {
    protected App app;

    public DataContainer(final App app) {
        this.app = app;
    }
}
