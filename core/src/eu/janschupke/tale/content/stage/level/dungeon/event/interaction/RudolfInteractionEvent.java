package eu.janschupke.tale.content.stage.level.dungeon.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;

/**
 * Interaction event for the Rudolf unit.
 *
 * @author jan.schupke@gmail.com
 */
public class RudolfInteractionEvent extends InteractionEvent {
    public RudolfInteractionEvent(final App app) {
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
