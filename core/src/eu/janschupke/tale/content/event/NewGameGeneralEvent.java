package eu.janschupke.tale.content.event;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Triggered when new game is requested. Log the action.
 *
 * @author jan.schupke@gmail.com
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
