package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Exploration event for the south optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class SouthExplorationEvent extends BaseEvent {
    public SouthExplorationEvent(final App app) {
        super(app, "");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
