package app.database;

import java.io.Closeable;

public interface ConnectionManager extends Closeable {
    void open() throws Exception;
}
