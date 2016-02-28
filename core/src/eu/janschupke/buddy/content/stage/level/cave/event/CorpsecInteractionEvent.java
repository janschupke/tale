package eu.janschupke.buddy.content.stage.level.cave.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event for the Corpsec unit interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecInteractionEvent extends BaseEvent {
    public CorpsecInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
