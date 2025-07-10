package io.schupke.tale.content.stage.level.settlement.event.interaction.chobo;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.settlement.SettlementScreen;
import io.schupke.tale.content.stage.level.settlement.quest.SettlementQuestManager;

/**
 * Key has been offered.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboKeyInteractionEvent extends InteractionEvent {
    public ChoboKeyInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((SettlementQuestManager) ((SettlementScreen) app.getScreen()).getQuestManager()).getKeyQuestChain();
        chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
        chain.transition();
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_CHOBO_KEY, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getInventory().removeItem(ItemTags.SETTLEMENT_HOUSE_KEY);
    }

    @Override
    protected void updateInteractions() {
        Interaction choboInteraction = app.getInteraction(InteractionTags.SETTLEMENT_CHOBO);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_HOUSE).setAvailable(false);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(false);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_HOUSE)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(false);
    }
}
