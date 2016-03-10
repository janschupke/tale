package eu.janschupke.tale.content.stage.level.settlement.event.interaction.smith;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.settlement.SettlementScreen;
import eu.janschupke.tale.content.stage.level.settlement.item.HouseKeyItem;
import eu.janschupke.tale.content.stage.level.settlement.quest.SettlementQuestManager;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.inventory.InventoryItem;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.exception.InventoryFullException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Key delivery quest accepted.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithKeyAcceptInteractionEvent extends InteractionEvent {
    public SmithKeyAcceptInteractionEvent(App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((SettlementQuestManager)((SettlementScreen) app.getScreenInstance(Screens.SETTLEMENT))
                .getQuestManager()).getKeyQuestChain();
        ((SettlementScreen) app.getScreenInstance(Screens.SETTLEMENT)).getQuestManager().initQuestChain(chain);
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_SMITH_ACCEPT, ((BaseScreen) app.getScreen()).getTag());

        // Adding key to inventory.
        try {
            Item keyItem = new HouseKeyItem(app.getGameState().getCurrentLevel().getWorld());
            app.getGameState().getInventory().addItem(new InventoryItem(app, keyItem));
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }

        app.getGameState().getGlobalLevelState().setSettlementKeyAcquired(true);
    }

    @Override
    protected void updateInteractions() {
        Interaction choboInteraction = app.getInteraction(InteractionTags.SETTLEMENT_CHOBO);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(true);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_HOUSE)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(true);
    }
}
