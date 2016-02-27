package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for screen transition from Forest to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionEvent extends BaseEvent {
    public OutskirtsTransitionEvent(final App app) {
        super(app, "");
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
