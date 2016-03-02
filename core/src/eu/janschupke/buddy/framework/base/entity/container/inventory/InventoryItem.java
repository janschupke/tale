package eu.janschupke.buddy.framework.base.entity.container.inventory;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.container.DataContainer;

/**
 * Single inventory item.
 *
 * @author jan.schupke@gmail.com
 */
public class InventoryItem extends DataContainer {
    private Item item;

    public InventoryItem(final App app, Item item) {
        super(app);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
