package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;

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
