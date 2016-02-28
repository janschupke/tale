package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Varpunen note area exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenExplorationEvent extends BaseEvent {
    public VarpunenExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
