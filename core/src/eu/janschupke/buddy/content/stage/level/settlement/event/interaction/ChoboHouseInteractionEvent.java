package eu.janschupke.buddy.content.stage.level.settlement.event.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionEvent;
import eu.janschupke.buddy.framework.base.event.handling.InteractionSwitch;

/**
 * Event for the Chobo's house interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboHouseInteractionEvent extends InteractionEvent {
    public ChoboHouseInteractionEvent(final App app) {
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
