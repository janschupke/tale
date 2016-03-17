package eu.janschupke.tale.content.stage.level.cave.event.interaction.corpsec;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.inventory.InventoryItem;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.exception.InventoryFullException;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.cave.CaveScreen;
import eu.janschupke.tale.content.stage.level.cave.item.JournalItem;
import eu.janschupke.tale.content.stage.level.cave.quest.CaveQuestManager;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;

/**
 * Journal looting event.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecLootInteractionEvent extends InteractionEvent {
    public CorpsecLootInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((CaveQuestManager) ((CaveScreen) app.getScreen()).getQuestManager()).getCorpsecQuestChain();
        ((CaveScreen) app.getScreen()).getQuestManager().initQuestChain(chain);
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_CORPSEC_LOOT, ((BaseScreen) app.getScreen()).getTag());

        // Adding the journal to the inventory.
        try {
            Item journalItem = new JournalItem(app.getGameState().getCurrentLevel().getWorld());
            app.getGameState().getInventory().addItem(new InventoryItem(app, journalItem));
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }
    }

    @Override
    protected void updateInteractions() {
        Interaction choboInteraction = app.getInteraction(InteractionTags.SETTLEMENT_CHOBO);
        choboInteraction.getSituation(SituationTags.SETTLEMENT_CHOBO_TALK)
                .getDecision(DecisionTags.SETTLEMENT_CHOBO_JOURNAL).setAvailable(true);

        Interaction corpsecInteraction = app.getInteraction(InteractionTags.CAVE_CORPSEC);
        corpsecInteraction.getSituation(SituationTags.CAVE_CORPSEC_INVESTIGATE)
                .getDecision(DecisionTags.CAVE_CORPSEC_INVESTIGATE_SEARCH).setAvailable(false);
    }
}
