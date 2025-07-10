package eu.janschupke.tale.base.exception;

/**
 * Exception thrown when no HUD is available.
 * Indicates that a required HUD component is missing.
 */
public class NoHudException extends Exception {
    public NoHudException() {
        super();
    }

    public NoHudException(String message) {
        super(message);
    }

    public NoHudException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoHudException(Throwable cause) {
        super(cause);
    }

    protected NoHudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
