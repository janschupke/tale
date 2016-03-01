package eu.janschupke.buddy.content.stage.level.forest.event.exploration;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.ExplorationEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.config.enumeration.tags.GameEventTags;

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
        app.getGameLog().addEntry(GameEventTags.FOREST_EAST_EXPLORATION, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
