package eu.janschupke.tale.content.stage.level.outskirts.event.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Event for the interaction with Crone's shack.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneShackInteractionEvent extends InteractionEvent {
    public CroneShackInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_SHACK, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
