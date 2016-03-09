package eu.janschupke.tale.content.stage.level.settlement.event.transition;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_TRANSITION_HOUSE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
