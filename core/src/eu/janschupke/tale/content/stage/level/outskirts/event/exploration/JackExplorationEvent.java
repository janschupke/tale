package eu.janschupke.tale.content.stage.level.outskirts.event.exploration;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.ExplorationEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for the Jack area exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class JackExplorationEvent extends ExplorationEvent {
    public JackExplorationEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_EXPLORATION_JACK, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
