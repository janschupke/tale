package io.schupke.tale.content.stage.level.outskirts.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the cave area.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveExplorationEvent extends ExplorationEvent {
    public CaveExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_EXPLORATION_CAVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
