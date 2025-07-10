package eu.janschupke.tale.base.container.inventory;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.DataContainer;
import eu.janschupke.tale.base.entity.Item;

/**
 * Represents an item in the player's inventory.
 * Contains item data and metadata.
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
