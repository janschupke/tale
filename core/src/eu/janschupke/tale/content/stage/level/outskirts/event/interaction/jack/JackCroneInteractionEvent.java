package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.jack;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Event for Jack-Crone interactions in the outskirts.
 * Handles conversations between Jack and the Crone characters.
 */
public class JackCroneInteractionEvent extends InteractionEvent {
    public JackCroneInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_CRONE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_CRONE).setAvailable(false);
    }
}
