package eu.janschupke.tale.framework.base.event;

import eu.janschupke.tale.content.stage.level.forest.ForestScreen;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Item;
import eu.janschupke.tale.framework.base.entity.container.inventory.InventoryItem;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.base.exception.InventoryFullException;

/**
 * Event for item pickups.
 *
 * @author jan.schupke@gmail.com
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
            ((ForestScreen) app.getScreen()).getWorld().removeItem(item);
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }

        updateMessages();
        updateQuests();
        updateGameState();
        updateInteractions();
    }
}
