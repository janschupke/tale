package io.schupke.tale.content.stage.level.settlement.event.interaction.smith;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Smith guitar rambling.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithRamblingInteractionEvent extends InteractionEvent {
    public SmithRamblingInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_SMITH_RAMBLING, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction pedroInteraction = app.getInteraction(InteractionTags.SETTLEMENT_SMITH);
        pedroInteraction.getSituation(SituationTags.SETTLEMENT_SMITH_TALK)
                .getDecision(DecisionTags.SETTLEMENT_SMITH_RAMBLING).setAvailable(false);
    }
}
