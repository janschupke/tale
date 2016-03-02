package eu.janschupke.tale.content.stage.level.cave.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;

/**
 * Event for the interaction with the Ville unit.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleInteractionEvent extends InteractionEvent {
    public VilleInteractionEvent(final App app) {
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
