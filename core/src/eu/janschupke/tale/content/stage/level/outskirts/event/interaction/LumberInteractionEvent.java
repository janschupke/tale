package eu.janschupke.tale.content.stage.level.outskirts.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;

/**
 * Event for interaction with the lumber item.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberInteractionEvent extends InteractionEvent {
    public LumberInteractionEvent(final App app) {
        super(app);
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
