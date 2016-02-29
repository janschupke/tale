package eu.janschupke.buddy.content.stage.level.settlement.event.transition;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.TransitionEvent;

/**
 * Event for the Smith's house entry.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithHouseTransitionEvent extends TransitionEvent {
    public SmithHouseTransitionEvent(final App app) {
        super(app);
        repeatable = true;
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
