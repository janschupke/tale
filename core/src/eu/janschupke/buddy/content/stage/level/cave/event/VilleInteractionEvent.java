package eu.janschupke.buddy.content.stage.level.cave.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the interaction with the Ville unit.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleInteractionEvent extends BaseEvent {
    public VilleInteractionEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
