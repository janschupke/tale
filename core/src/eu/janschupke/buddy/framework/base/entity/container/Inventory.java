package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.exception.InventoryFullException;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

import java.util.ArrayList;
import java.util.List;

/**
 * Container of inventory items.
 *
 * @author jan.schupke@gmail.com
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
        setChanged();
        notifyObservers();
    }

    public void removeItem(int index) throws IllegalArgumentException {
        if (index >= capacity || index < 0)
            throw new IllegalArgumentException("Requesting inventory item removal out of bounds.");
        items.remove(index);
        usedSlots--;
        setChanged();
        notifyObservers();
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
                setChanged();
                notifyObservers();
                return;
            }
        }
    }

    public int getUsedSlots() {
        return usedSlots;
    }
}
