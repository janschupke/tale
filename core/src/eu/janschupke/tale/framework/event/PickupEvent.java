package eu.janschupke.tale.framework.event;

import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.inventory.InventoryItem;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.exception.InventoryFullException;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;

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