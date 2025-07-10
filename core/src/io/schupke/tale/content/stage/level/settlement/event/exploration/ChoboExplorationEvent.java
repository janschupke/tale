package io.schupke.tale.content.stage.level.settlement.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

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
