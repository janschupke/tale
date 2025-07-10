package eu.janschupke.tale.content.stage.level.outskirts.event.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for lumber interactions in the outskirts.
 * Handles lumber collection and quest progression.
 */
public class LumberInteractionEvent extends InteractionEvent {
    public LumberInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_LUMBER_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
