package app.database;

import java.io.IOException;
import java.sql.SQLException;

public class FileManager implements FileManagement {

    private final FileConnection connection;

    public FileManager(String filePath) {
        this.connection = new FileConnector(filePath);
    }

    @Override
    public void save(Object dataset) {
        try {
            connection.open();
            connection.save(dataset);
        } catch (IOException | SQLException error) {
            error.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException ignored) {}
        }
    }

    @Override
    public Object read() {
        try {
            return connection.read();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (IOException ignored) {}
        }
    }

    @Override
    public boolean deleteSelf() {
        return connection.delete();
    }
}
