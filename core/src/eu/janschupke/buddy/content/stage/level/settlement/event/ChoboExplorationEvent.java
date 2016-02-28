package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Exploration event for the Chobo's house area.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboExplorationEvent extends BaseEvent {
    public ChoboExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
