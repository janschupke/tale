package eu.janschupke.buddy.content.stage.level.house.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the bed obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class BedInteractionEvent extends BaseEvent {
    public BedInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
