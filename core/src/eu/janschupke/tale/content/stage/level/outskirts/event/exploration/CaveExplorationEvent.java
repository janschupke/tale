package eu.janschupke.tale.content.stage.level.outskirts.event.exploration;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.ExplorationEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

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