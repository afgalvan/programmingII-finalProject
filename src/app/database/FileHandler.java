package app.database;

import java.io.Closeable;
import java.io.IOException;

public interface FileHandler extends Closeable {
    void save(Object data) throws IOException;

    Object read() throws IOException, ClassNotFoundException;
}
