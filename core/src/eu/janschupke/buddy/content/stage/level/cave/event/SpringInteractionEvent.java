package eu.janschupke.buddy.content.stage.level.cave.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the interaction with the spring.
 *
 * @author jan.schupke@gmail.com
 */
public class SpringInteractionEvent extends BaseEvent {
    public SpringInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
