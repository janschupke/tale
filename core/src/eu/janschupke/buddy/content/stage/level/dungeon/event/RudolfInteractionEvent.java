package eu.janschupke.buddy.content.stage.level.dungeon.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the Rudolf unit.
 *
 * @author jan.schupke@gmail.com
 */
public class RudolfInteractionEvent extends BaseEvent {
    public RudolfInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
