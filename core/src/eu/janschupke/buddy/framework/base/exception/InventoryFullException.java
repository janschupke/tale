package eu.janschupke.buddy.framework.base.exception;

/**
 * Thrown when trying to add an item to a full inventory.
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
