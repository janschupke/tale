package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Jack area exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class JackExplorationEvent extends BaseEvent {
    public JackExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
