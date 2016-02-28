package eu.janschupke.buddy.content.stage.level.house.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.PickupEvent;

/**
 * Pickup event for the book.
 *
 * @author jan.schupke@gmail.com
 */
public class BookPickupEvent extends PickupEvent {
    public BookPickupEvent(final App app) {
        // TODO
        super(app, "TODO");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
