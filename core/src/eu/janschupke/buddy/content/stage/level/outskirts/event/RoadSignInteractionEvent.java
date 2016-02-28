package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Interaction event for the crossroad sign.
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
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
