package eu.janschupke.tale.content.event;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for starting a new game.
 * Handles game initialization and reset functionality.
 */
public class NewGameGeneralEvent extends GeneralEvent {
    public NewGameGeneralEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    protected void updateMessages() {
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.GLOBAL_NEW_GAME, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
