package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event for the interaction with Jack's house.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseInteractionEvent extends BaseEvent {
    public JackHouseInteractionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
