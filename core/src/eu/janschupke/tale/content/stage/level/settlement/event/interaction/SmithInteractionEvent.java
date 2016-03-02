package eu.janschupke.tale.content.stage.level.settlement.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;

/**
 * Interaction event for the Smith unit.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithInteractionEvent extends InteractionEvent {
    public SmithInteractionEvent(final App app) {
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
