package eu.janschupke.tale.content.stage.level.settlement.event.exploration;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.ExplorationEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the Chobo's house area.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboExplorationEvent extends ExplorationEvent {
    public ChoboExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_EXPLORATION_CHOBO, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
