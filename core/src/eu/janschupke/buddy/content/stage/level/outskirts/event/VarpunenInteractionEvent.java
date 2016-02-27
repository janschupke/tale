package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for interaction with the Varpunen note item.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenInteractionEvent extends BaseEvent {
    public VarpunenInteractionEvent(final App app) {
        super(app, "");
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
