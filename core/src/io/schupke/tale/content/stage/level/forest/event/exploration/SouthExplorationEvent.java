package io.schupke.tale.content.stage.level.forest.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the south optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class SouthExplorationEvent extends ExplorationEvent {
    public SouthExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.FOREST_EXPLORATION_SOUTH, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
