package io.schupke.tale.content.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.GeneralEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

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
