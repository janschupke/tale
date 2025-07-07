package eu.janschupke.tale.base.exception;

/**
 * Thrown when trying to access the in-game hud
 * while being outside any level.
 *
 * @author jan.schupke@gmail.com
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
