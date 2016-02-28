package eu.janschupke.buddy.content.stage.level.house.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.PickupEvent;

/**
 * Pickup event for the mead item.
 *
 * @author jan.schupke@gmail.com
 */
public class MeadPickupEvent extends PickupEvent {
    public MeadPickupEvent(final App app) {
        // TODO
        super(app, "TODO");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
