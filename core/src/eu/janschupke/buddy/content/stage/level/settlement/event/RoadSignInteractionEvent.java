package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the road sign.
 *
 * @author jan.schupke@gmail.com
 */
public class RoadSignInteractionEvent extends BaseEvent {
    public RoadSignInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
