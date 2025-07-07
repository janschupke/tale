package eu.janschupke.tale.base.event.handling;

import eu.janschupke.tale.base.App;

/**
 * Base class for event handlers that are instantiated per game level.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class LevelEventHandler {
    protected App app;

    public LevelEventHandler(final App app) {
        this.app = app;
    }
}
