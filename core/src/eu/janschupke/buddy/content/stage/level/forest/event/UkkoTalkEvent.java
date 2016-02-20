package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Interaction event for the Ukko unit in the forest.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoTalkEvent extends BaseEvent {
    public UkkoTalkEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
