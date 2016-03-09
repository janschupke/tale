package eu.janschupke.tale.content.stage.level.house.event.exploration;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.ExplorationEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Exploration event for the partial room exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomExplorationEvent extends ExplorationEvent {
    public RoomExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.HOUSE_EXPLORATION_ROOM, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
