package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionEvent;
import eu.janschupke.buddy.framework.base.event.handling.InteractionSwitch;

/**
 * Event for the interaction with Jack's house.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseInteractionEvent extends InteractionEvent {
    public JackHouseInteractionEvent(final App app) {
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
