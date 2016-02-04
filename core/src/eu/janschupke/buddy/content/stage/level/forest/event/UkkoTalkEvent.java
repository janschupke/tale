package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the Ukko unit in the forest.
 */
public class UkkoTalkEvent extends BaseEvent {
    public UkkoTalkEvent(final App app) {
        super(app);
        // TODO
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        // TODO
    }
}
