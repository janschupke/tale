package eu.janschupke.tale.base.event;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.inventory.InventoryItem;
import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.exception.InventoryFullException;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;

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
