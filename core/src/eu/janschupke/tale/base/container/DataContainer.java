package eu.janschupke.tale.base.container;

import java.util.Observable;

import eu.janschupke.tale.base.App;

/**
 * Base class for data containers.
 * Provides common functionality for data management and storage.
 */
public abstract class DataContainer extends Observable {
    protected App app;

    public DataContainer(final App app) {
        this.app = app;
    }

    /**
     * Informs observers that the state of this object has changed.
     */
    public final void update() {
        setChanged();
        notifyObservers();
    }
}
