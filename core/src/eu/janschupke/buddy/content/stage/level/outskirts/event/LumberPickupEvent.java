package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.PickupEvent;

/**
 * Event for the lumber item pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberPickupEvent extends PickupEvent {
    public LumberPickupEvent(final App app) {
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
