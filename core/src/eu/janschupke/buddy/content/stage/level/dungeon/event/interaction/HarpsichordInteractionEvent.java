package eu.janschupke.buddy.content.stage.level.dungeon.event.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionEvent;
import eu.janschupke.buddy.framework.base.event.handling.InteractionSwitch;

/**
 * Interaction event for the harpsichord.
 *
 * @author jan.schupke@gmail.com
 */
public class HarpsichordInteractionEvent extends InteractionEvent {
    public HarpsichordInteractionEvent(final App app) {
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