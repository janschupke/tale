package eu.janschupke.buddy.content.stage.level.dungeon.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the first book.
 *
 * @author jan.schupke@gmail.com
 */
public class BookOneInteractionEvent extends BaseEvent {
    public BookOneInteractionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}