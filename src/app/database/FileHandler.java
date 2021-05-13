package app.database;

import java.io.Closeable;
import java.io.IOException;

public interface FileHandler<T> extends Closeable {
    void save(T data) throws IOException;

    Object read() throws IOException, ClassNotFoundException;
}
