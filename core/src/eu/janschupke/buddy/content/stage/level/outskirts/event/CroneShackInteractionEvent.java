package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event for the interaction with Crone's shack.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneShackInteractionEvent extends BaseEvent {
    public CroneShackInteractionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
