package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.varpunen;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * General event that occurs when the Varpunen note is shown.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenShowInteractionEvent extends InteractionEvent {
    public VarpunenShowInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_GIVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction croneInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_CRONE);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW).setAvailable(false);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(true);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(true);
    }
}
