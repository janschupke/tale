package eu.janschupke.tale.content.stage.level.dungeon.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;

/**
 * Interaction event for the door of the second dungeon room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomTwoDoorInteractionEvent extends InteractionEvent {
    public RoomTwoDoorInteractionEvent(final App app) {
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
    }

    @Override
    protected void updateInteractions() {

    }
}
