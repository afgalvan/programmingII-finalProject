package app.exceptions;

public class DataAccessException extends Exception {

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataAccessException(Throwable throwable) {
        super(throwable);
    }

    public DataAccessException(
        String message,
        Throwable throwable,
        boolean b,
        boolean b1
    ) {
        super(message, throwable, b, b1);
    }
}
