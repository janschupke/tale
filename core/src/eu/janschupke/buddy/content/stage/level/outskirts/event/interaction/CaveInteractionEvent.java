package eu.janschupke.buddy.content.stage.level.outskirts.event.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionEvent;
import eu.janschupke.buddy.framework.base.event.handling.InteractionSwitch;

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
