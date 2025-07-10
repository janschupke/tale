package io.schupke.tale.content.stage.level.settlement.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the dungeon area.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonExplorationEvent extends ExplorationEvent {
    public DungeonExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_EXPLORATION_DUNGEON, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
