package eu.janschupke.tale.content.stage.level.dungeon.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.InteractionEvent;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;

/**
 * Interaction event for the door of fourth dungeon room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomFourDoorInteractionEvent extends InteractionEvent {
    public RoomFourDoorInteractionEvent(final App app) {
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
