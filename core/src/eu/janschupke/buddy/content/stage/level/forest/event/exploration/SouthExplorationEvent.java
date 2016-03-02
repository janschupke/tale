package eu.janschupke.buddy.content.stage.level.forest.event.exploration;

import eu.janschupke.buddy.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.ExplorationEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;

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
        app.getGameLog().addEntry(GameEventTags.FOREST_SOUTH_EXPLORATION, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
