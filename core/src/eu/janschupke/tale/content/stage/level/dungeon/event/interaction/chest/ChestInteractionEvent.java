package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Interaction event for the chest item.
 *
 * @author jan.schupke@gmail.com
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
