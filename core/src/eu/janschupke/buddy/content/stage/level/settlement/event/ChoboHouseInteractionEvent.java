package eu.janschupke.buddy.content.stage.level.settlement.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Event for the Chobo's house interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboHouseInteractionEvent extends BaseEvent {
    public ChoboHouseInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
    }
}
