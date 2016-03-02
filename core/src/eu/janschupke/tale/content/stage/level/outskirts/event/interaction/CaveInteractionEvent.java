package eu.janschupke.tale.content.stage.level.outskirts.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;

/**
 * Event for interaction with the cave obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveInteractionEvent extends InteractionEvent {
    public CaveInteractionEvent(App app) {
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
