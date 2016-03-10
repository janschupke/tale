package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Searching the chest.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestSearchInteractionEvent extends InteractionEvent {
    public ChestSearchInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_CHEST_SEARCH, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
