package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event for interaction with the lumber item.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberInteractionEvent extends BaseEvent {
    public LumberInteractionEvent(final App app) {
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
