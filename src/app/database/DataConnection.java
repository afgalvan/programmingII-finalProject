package app.database;

import java.io.Closeable;

public interface Connection extends Closeable {
    void open() throws Exception;
}
