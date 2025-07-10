package io.schupke.tale.base.event.handling;

import io.schupke.tale.base.App;

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
