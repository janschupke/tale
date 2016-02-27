package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Varpunen note pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenPickupEvent extends BaseEvent {
    public VarpunenPickupEvent(final App app) {
        super(app, "");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
