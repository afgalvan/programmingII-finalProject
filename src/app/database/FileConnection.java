package app.database;

import java.io.IOException;

interface FileConnection extends DataConnection {
    void save(Object data) throws IOException;

    Object read() throws IOException, ClassNotFoundException;

    boolean delete();
}
