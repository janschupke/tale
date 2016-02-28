package eu.janschupke.buddy.content.stage.level.dungeon.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Interaction event for the door of the second dungeon room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomTwoDoorInteractionEvent extends BaseEvent {
    public RoomTwoDoorInteractionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
