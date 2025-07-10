package io.schupke.tale.content.stage.level.dungeon.event.interaction.chest;

import com.badlogic.gdx.Gdx;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.inventory.InventoryItem;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.exception.InventoryFullException;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.dungeon.item.GateKeyItem;
import io.schupke.tale.content.ui.dialog.InventoryFullDialog;

/**
 * Event for collecting items from chests in the dungeon.
 * Handles item collection and inventory management.
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
