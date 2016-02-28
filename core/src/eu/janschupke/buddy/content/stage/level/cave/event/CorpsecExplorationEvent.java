package eu.janschupke.buddy.content.stage.level.cave.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Corpsec area exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecExplorationEvent extends BaseEvent {
    public CorpsecExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
