package io.schupke.tale.content.stage.level.forest.event.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Ukko discussion event.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoDiscussInteractionEvent extends InteractionEvent {
    public UkkoDiscussInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.FOREST_INTERACTION_UKKO_DISCUSS, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction ukkoInteraction = app.getInteraction(InteractionTags.FOREST_UKKO);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_TALK)
                .getDecision(DecisionTags.FOREST_UKKO_DISCUSS).setAvailable(false);
    }
}
