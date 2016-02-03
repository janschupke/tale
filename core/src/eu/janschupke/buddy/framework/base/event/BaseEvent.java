package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;

/**
 * Base class for all in-game events.
 */
public abstract class BaseEvent {
    protected App app;
    protected boolean triggered;
    protected boolean repeatable;

    public BaseEvent(final App app) {
        this.app = app;
    }

    public void trigger() {
        if (triggered && !repeatable) return;
        triggered = true;
        ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stop();
    }
}
