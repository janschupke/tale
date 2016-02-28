package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.PickupEvent;

/**
 * Event for the Varpunen note pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenPickupEvent extends PickupEvent {
    public VarpunenPickupEvent(final App app) {
        // TODO
        super(app, "TODO");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        // TODO
    }
}
