package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the farm house.
 *
 * @author jan.schupke@gmail.com
 */
public class FarmInteractionEvent extends BaseEvent {
    public FarmInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}