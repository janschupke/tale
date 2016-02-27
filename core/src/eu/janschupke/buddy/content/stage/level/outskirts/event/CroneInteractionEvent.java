package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for interaction with the Crone unit.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneInteractionEvent extends BaseEvent {
    public CroneInteractionEvent(final App app) {
        super(app, "");
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
