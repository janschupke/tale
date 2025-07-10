package eu.janschupke.tale.base.container.inventory;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.DataContainer;
import eu.janschupke.tale.base.exception.InventoryFullException;
import eu.janschupke.tale.content.config.enumeration.ItemTags;

/**
 * Manages the player's inventory system.
 * Handles item collection, storage, and management.
 */
public class Inventory extends DataContainer {
    private List<InventoryItem> items;
    private int capacity;
    private int usedSlots;

    public Inventory(final App app, int capacity) {
        super(app);
        items = new ArrayList<>();
        this.capacity = capacity;
        this.usedSlots = 0;
    }

    public InventoryItem getItem(int index) throws IllegalArgumentException {
        if (index >= capacity || index < 0)
            throw new IllegalArgumentException("Requesting inventory item out of bounds.");
        return items.get(index);
    }

    public void addItem(InventoryItem item) throws InventoryFullException {
        if (usedSlots == capacity) throw new InventoryFullException("Inventory is full.");
        items.add(item);
        usedSlots++;
        update();
    }

    /**
     * Removes an inventory item based on the provided tag.
     * @param tag Identification tag of the item to be removed.
     */
    public void removeItem(ItemTags tag) {
        for (InventoryItem item : items) {
            if (item.getItem().getTag() == tag) {
                items.remove(item);
                usedSlots--;
                update();
                Gdx.app.debug("Inventory#removeItem", String.format("Removing: %s", tag));
                Gdx.app.debug("Inventory#removeItem", String.format("Current items: %d", usedSlots));
                return;
            }
        }
    }

    public int getUsedSlots() {
        return usedSlots;
    }
}
