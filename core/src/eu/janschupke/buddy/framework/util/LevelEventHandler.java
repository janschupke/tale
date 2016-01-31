package eu.janschupke.buddy.framework.util;

import eu.janschupke.buddy.framework.base.screen.BaseScreen;

/**
 * Base class for event handlers that are instantiated per game level.
 */
// TODO: move somewhere else?
public abstract class LevelEventHandler {
    protected BaseScreen screen;

    public LevelEventHandler(BaseScreen screen) {
        this.screen = screen;
    }
}
