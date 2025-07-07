package eu.janschupke.tale_analyzer.exception;

/**
 * Thrown when data folder contains invalid data,
 * or has invalid structure.
 *
 * @author jan.schupke@gmail.com
 */
public class InvalidDataSetException extends Exception {
    public InvalidDataSetException() {
        super();
    }

    public InvalidDataSetException(String message) {
        super(message);
    }

    public InvalidDataSetException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataSetException(Throwable cause) {
        super(cause);
    }

    protected InvalidDataSetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
