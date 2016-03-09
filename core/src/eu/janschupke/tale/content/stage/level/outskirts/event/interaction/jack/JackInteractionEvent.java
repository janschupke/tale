package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.jack;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Event for interaction with the Jack unit.
 *
 * @author jan.schupke@gmail.com
 */
public class JackInteractionEvent extends InteractionEvent {
    public JackInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_TALK, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}