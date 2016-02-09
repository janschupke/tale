package eu.janschupke.buddy.framework.base.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.container.InventoryItem;
import eu.janschupke.buddy.framework.base.exception.InventoryFullException;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for item pickups.
 */
public class PickupEvent extends BaseEvent {
    protected Item item;

    public PickupEvent(final App app) {
        this(app, "");
    }

    public PickupEvent(final App app, String eventMessage) {
        super(app);
        this.eventMessage = eventMessage;
    }

    @Override
    public void trigger() {
        super.trigger();

        try {
            app.getGameState().getInventory().addItem(new InventoryItem(app, item));
            ((ForestScreen) app.getScreen()).getWorld().removeItem(item);
            Utility.getHud(app).getInventoryTable().update();
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        } catch (NoHudException e) {
            Gdx.app.log("PickupEvent#trigger", "No HUD problem.");
        }
    }
}
