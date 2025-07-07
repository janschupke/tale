package eu.janschupke.tale_analyzer.exception;

/**
 * Thrown when the requested personality trait is not found.
 *
 * @author jan.schupke@gmail.com
 */
public class TraitNotFoundException extends Exception {
    public TraitNotFoundException() {
        super();
    }

    public TraitNotFoundException(String message) {
        super(message);
    }

    public TraitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraitNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TraitNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
