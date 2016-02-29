package eu.janschupke.buddy.content.stage.level.dungeon.event.transition;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.TransitionEvent;

/**
 * Transition event that ends the game.
 *
 * @author jan.schupke@gmail.com
 */
public class ExitTransitionEvent extends TransitionEvent {
    public ExitTransitionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {

    }

    @Override
    protected void updateInteractions() {

    }
}
