package eu.janschupke.buddy.framework.base.interaction;

/**
 * Thrown when attempting to transition forward from the last
 * possible situation within an interaction.
 */
public class NoMoreSituationsException extends Exception {
    public NoMoreSituationsException() {
        super();
    }

    public NoMoreSituationsException(String message) {
        super(message);
    }

    public NoMoreSituationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreSituationsException(Throwable cause) {
        super(cause);
    }

    protected NoMoreSituationsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
