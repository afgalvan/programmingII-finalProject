package app.database;

import java.io.IOException;
import java.sql.SQLException;

/**
 * A class to manage operations to a objects file to store data.
 */
public class FileManager implements FileManagement {

    private final FileConnection connection;

    public FileManager(String filePath) {
        this.connection = new FileConnector(filePath);
    }

    /**
     * Saves the given object to the file specified.
     *
     * @param dataset the {@code Object} to be saved.
     */
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

    /**
     * Read the contents of the file specified in constructor.
     *
     * @return the {@code Object} read from the file.
     */
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
