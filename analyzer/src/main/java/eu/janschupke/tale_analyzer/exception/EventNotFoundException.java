package eu.janschupke.tale_analyzer.exception;

/**
 * Thrown when the requested event tag is not found.
 *
 * @author jan.schupke@gmail.com
 */
public class EventNotFoundException extends Exception {
    public EventNotFoundException() {
        super();
    }

    public EventNotFoundException(String message) {
        super(message);
    }

    public EventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EventNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
