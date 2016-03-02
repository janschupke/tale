package eu.janschupke.tale.content.stage.level.settlement.event.transition;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;

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
