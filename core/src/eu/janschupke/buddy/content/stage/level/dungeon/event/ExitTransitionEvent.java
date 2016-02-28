package eu.janschupke.buddy.content.stage.level.dungeon.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Transition event that ends the game.
 *
 * @author jan.schupke@gmail.com
 */
public class ExitTransitionEvent extends BaseEvent {
    public ExitTransitionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        // TODO: exit
    }
}
