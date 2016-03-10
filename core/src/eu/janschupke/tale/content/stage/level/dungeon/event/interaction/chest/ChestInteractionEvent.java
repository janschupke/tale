package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

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
    }

    @Override
    protected void updateInteractions() {

    }
}