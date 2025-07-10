package eu.janschupke.tale.base.exception;

/**
 * Exception thrown when the inventory is full.
 * Indicates that no more items can be added to the inventory.
 */
public class InventoryFullException extends Exception {
    public InventoryFullException() {
        super();
    }

    public InventoryFullException(String message) {
        super(message);
    }

    public InventoryFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryFullException(Throwable cause) {
        super(cause);
    }

    protected InventoryFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
