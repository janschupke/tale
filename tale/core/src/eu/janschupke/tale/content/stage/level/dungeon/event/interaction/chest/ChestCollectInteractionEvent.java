package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.inventory.InventoryItem;
import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.exception.InventoryFullException;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.dungeon.item.GateKeyItem;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;

/**
 * Collecting the key from the chest.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestCollectInteractionEvent extends InteractionEvent {
    public ChestCollectInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_CHEST_COLLECT, ((BaseScreen) app.getScreen()).getTag());

        // Adding the gate key to the inventory.
        try {
            Item gateKeyItem = new GateKeyItem(app.getGameState().getCurrentLevel().getWorld());
            app.getGameState().getInventory().addItem(new InventoryItem(app, gateKeyItem));
            Gdx.app.debug("ChestCollectInteractionEvent#updateGameState", "Adding key to inventory");
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }

    }

    @Override
    protected void updateInteractions() {
        Interaction gateInteraction = app.getInteraction(InteractionTags.DUNGEON_GATE);
        gateInteraction.getSituation(SituationTags.DUNGEON_GATE_INVESTIGATE)
                .getDecision(DecisionTags.DUNGEON_GATE_OPEN).setAvailable(true);

        Interaction chestInteraction = app.getInteraction(InteractionTags.DUNGEON_CHEST);
        chestInteraction.getSituation(SituationTags.DUNGEON_CHEST_INVESTIGATE)
                .getDecision(DecisionTags.DUNGEON_CHEST_SEARCH).setAvailable(false);
    }
}
