package eu.janschupke.buddy.framework.util;

import eu.janschupke.buddy.framework.App;

/**
 * Base class for event handlers that are instantiated per game level.
 */
// TODO: move somewhere else?
public abstract class LevelEventHandler {
    protected App app;

    public LevelEventHandler(final App app) {
        this.app = app;
    }
}
