package eu.janschupke.tale.content.stage.level.forest.event.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Interaction event for Ukko.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoInteractionEvent extends InteractionEvent {
    public UkkoInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.FOREST_INTERACTION_UKKO_TALK, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getUkkoSound());
    }

    @Override
    protected void updateInteractions() {
        Interaction ukkoInteraction = app.getInteraction(InteractionTags.FOREST_UKKO);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_TALK)
                .getDecision(DecisionTags.FOREST_UKKO_DISCUSS).setAvailable(false);
    }
}
