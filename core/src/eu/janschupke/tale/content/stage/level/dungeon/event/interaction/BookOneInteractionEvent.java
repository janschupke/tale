package eu.janschupke.tale.content.stage.level.dungeon.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;

/**
 * Interaction event for the first book.
 *
 * @author jan.schupke@gmail.com
 */
public class BookOneInteractionEvent extends InteractionEvent {
    public BookOneInteractionEvent(final App app) {
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
