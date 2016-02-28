package eu.janschupke.buddy.content.stage.level.house.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Exploration event for the far side of the room.
 *
 * @author jan.schupke@gmail.com
 */
public class FarExplorationEvent extends BaseEvent {
    public FarExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
