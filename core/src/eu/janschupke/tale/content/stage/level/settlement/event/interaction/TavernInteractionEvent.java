package eu.janschupke.tale.content.stage.level.settlement.event.interaction;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;

/**
 * Interaction event for the tavern building.
 *
 * @author jan.schupke@gmail.com
 */
public class TavernInteractionEvent extends InteractionEvent {
    public TavernInteractionEvent(final App app) {
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
