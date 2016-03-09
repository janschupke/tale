package eu.janschupke.tale.content.stage.level.forest.event.exploration;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.ExplorationEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Exploration event for the east optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class EastExplorationEvent extends ExplorationEvent {
    public EastExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.FOREST_EXPLORATION_EAST, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
