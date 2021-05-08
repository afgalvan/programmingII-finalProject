package app.exceptions;

public class RowsOutOfBoundsException extends IndexOutOfBoundsException {

    public RowsOutOfBoundsException() {}

    public RowsOutOfBoundsException(String s) {
        super(s);
    }
}
