package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the tavern building.
 *
 * @author jan.schupke@gmail.com
 */
public class TavernInteractionEvent extends BaseEvent {
    public TavernInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
