package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.container.InventoryItem;
import eu.janschupke.buddy.framework.base.exception.InventoryFullException;

/**
 * Event for item pickups.
 *
 * @author jan.schupke@gmail.com
 */
public class PickupEvent extends BaseEvent {
    protected Item item;

    public PickupEvent(final App app, String eventMessage) {
        super(app);
        this.eventMessage = eventMessage;
    }

    @Override
    public void trigger() {
        super.trigger();

        try {
            item = ((Item) InteractionSwitch.getTriggerable());
            app.getGameState().getInventory().addItem(new InventoryItem(app, item));
            ((ForestScreen) app.getScreen()).getWorld().removeItem(item);
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }
    }
}
