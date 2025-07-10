package io.schupke.tale.base.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.inventory.InventoryItem;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.exception.InventoryFullException;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.ui.dialog.InventoryFullDialog;

/**
 * Represents a pickup event.
 * Handles events related to item collection and inventory management.
 */
public abstract class PickupEvent extends BaseEvent {
    protected Item item;

    public PickupEvent(final App app) {
        this(app, "");
    }

    public PickupEvent(final App app, final String eventMessage) {
        super(app, eventMessage);
    }

    @Override
    public final void trigger() {
        if (!canTrigger()) return;
        super.trigger();

        // Adding item to the inventory and removing it from the world.
        try {
            item = ((Item) InteractionSwitch.getTriggerable());
            app.getGameState().getInventory().addItem(new InventoryItem(app, item));
            ((GameScreen) app.getScreen()).getWorld().removeItem(item);
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }

        updateMessages();
        updateQuests();
        updateGameState();
        updateInteractions();
    }
}
