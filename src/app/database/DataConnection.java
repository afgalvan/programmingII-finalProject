package app.database;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public interface DataConnection extends Closeable {
    void open() throws IOException, SQLException;
}
