package eu.janschupke.buddy.content.stage.level.dungeon.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Exploration event for the study area.
 *
 * @author jan.schupke@gmail.com
 */
public class StudyExplorationEvent extends BaseEvent {
    public StudyExplorationEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
