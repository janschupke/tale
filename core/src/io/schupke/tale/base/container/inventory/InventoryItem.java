package io.schupke.tale.base.container.inventory;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;
import io.schupke.tale.base.entity.Item;

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
