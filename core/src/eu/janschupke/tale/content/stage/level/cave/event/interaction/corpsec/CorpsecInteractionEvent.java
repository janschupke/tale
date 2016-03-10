package eu.janschupke.tale.content.stage.level.cave.event.interaction.corpsec;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Event for the Corpsec unit interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecInteractionEvent extends InteractionEvent {
    public CorpsecInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_CORPSEC_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}