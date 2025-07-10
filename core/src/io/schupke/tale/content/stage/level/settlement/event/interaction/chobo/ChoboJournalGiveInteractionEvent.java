package io.schupke.tale.content.stage.level.settlement.event.interaction.chobo;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Journal was offered.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboJournalGiveInteractionEvent extends InteractionEvent {
    public ChoboJournalGiveInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_CHOBO_JOURNAL_GIVE, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getInventory().removeItem(ItemTags.CAVE_JOURNAL);
    }

    @Override
    protected void updateInteractions() {
        Interaction choboInteraction = app.getInteraction(InteractionTags.SETTLEMENT_CHOBO);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_JOURNAL).setAvailable(false);
    }
}
