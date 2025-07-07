package eu.janschupke.tale.content.stage.level.settlement.event.interaction.chobo;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.settlement.SettlementScreen;
import eu.janschupke.tale.content.stage.level.settlement.quest.SettlementQuestManager;

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
