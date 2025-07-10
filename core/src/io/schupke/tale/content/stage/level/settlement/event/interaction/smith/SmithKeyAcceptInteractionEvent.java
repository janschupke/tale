package io.schupke.tale.content.stage.level.settlement.event.interaction.smith;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.inventory.InventoryItem;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.exception.InventoryFullException;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.settlement.SettlementScreen;
import io.schupke.tale.content.stage.level.settlement.item.HouseKeyItem;
import io.schupke.tale.content.stage.level.settlement.quest.SettlementQuestManager;
import io.schupke.tale.content.ui.dialog.InventoryFullDialog;

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

        // Adding house key to inventory.
        try {
            Item keyItem = new HouseKeyItem(app.getGameState().getCurrentLevel().getWorld());
            app.getGameState().getInventory().addItem(new InventoryItem(app, keyItem));
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }
    }

    @Override
    protected void updateInteractions() {
        // Enabling quest completion decisions.
        Interaction choboInteraction = app.getInteraction(InteractionTags.SETTLEMENT_CHOBO);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(true);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_HOUSE)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_KEY).setAvailable(true);

        // Disabling quest init decisions.
        Interaction smithInteraction = app.getInteraction(InteractionTags.SETTLEMENT_SMITH);
        smithInteraction.getSituation(SituationTags.SETTLEMENT_SMITH_TALK)
                .getDecision(DecisionTags.SETTLEMENT_SMITH_ASSISTANCE).setAvailable(false);
        smithInteraction.getSituation(SituationTags.SETTLEMENT_SMITH_RAMBLE)
                .getDecision(DecisionTags.SETTLEMENT_SMITH_ASSISTANCE).setAvailable(false);
    }
}
