package app.database;

import java.io.Closeable;

public interface DataConnection extends Closeable {
    void open() throws Exception;
}
