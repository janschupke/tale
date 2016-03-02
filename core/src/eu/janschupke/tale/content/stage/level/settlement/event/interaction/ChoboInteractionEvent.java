package eu.janschupke.tale.content.stage.level.settlement.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.InteractionEvent;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;

/**
 * Interaction event for Chobo unit.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboInteractionEvent extends InteractionEvent {
    public ChoboInteractionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        InteractionSwitch.getTriggerable().startInteraction(app);
    }

    @Override
    protected void updateInteractions() {

    }
}
