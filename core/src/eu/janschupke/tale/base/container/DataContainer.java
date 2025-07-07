package eu.janschupke.tale.base.container;

import eu.janschupke.tale.base.App;

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

    /**
     * Informs observers that the state of this object has changed.
     */
    public final void update() {
        setChanged();
        notifyObservers();
    }
}
