package eu.janschupke.tale_analyzer.exception;

/**
 * Thrown when trying to assign impossible correlation value.
 *
 * @author jan.schupke@gmail.com
 */
public class InvalidCorrelationValueException extends Exception {
    public InvalidCorrelationValueException() {
        super();
    }

    public InvalidCorrelationValueException(String message) {
        super(message);
    }

    public InvalidCorrelationValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCorrelationValueException(Throwable cause) {
        super(cause);
    }

    protected InvalidCorrelationValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
