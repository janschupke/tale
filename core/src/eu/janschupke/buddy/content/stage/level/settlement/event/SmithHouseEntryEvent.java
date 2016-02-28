package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Smith's house entry.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithHouseEntryEvent extends BaseEvent {
    public SmithHouseEntryEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
