package eu.janschupke.tale.content.stage.level.house.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;

/**
 * Interaction event for the book item.
 *
 * @author jan.schupke@gmail.com
 */
public class BookInteractionEvent extends InteractionEvent {
    public BookInteractionEvent(final App app) {
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
