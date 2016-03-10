package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Collecting the key from the chest.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestCollectInteractionEvent extends InteractionEvent {
    public ChestCollectInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_CHEST_COLLECT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
