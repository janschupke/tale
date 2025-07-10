package eu.janschupke.tale.base.event.handling;

import eu.janschupke.tale.base.App;

/**
 * Handles level-specific events.
 * Manages events that occur within individual game levels.
 */
public abstract class LevelEventHandler {
    protected App app;

    public LevelEventHandler(final App app) {
        this.app = app;
    }
}
