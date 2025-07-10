package io.schupke.tale.content.stage.level.dungeon.event.interaction.chest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for chest interactions in the dungeon.
 * Handles chest opening and item discovery.
 */
public class ChestInteractionEvent extends InteractionEvent {
    public ChestInteractionEvent(final App app) {
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
        InteractionSwitch.getTriggerable().startInteraction(app);
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_CHEST_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSound(
                app.getResourceManager().getSoundHandler().getChestSound());
    }

    @Override
    protected void updateInteractions() {

    }
}
