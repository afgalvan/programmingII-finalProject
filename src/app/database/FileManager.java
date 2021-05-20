package app.database;

import app.exceptions.InputFileException;
import java.io.IOException;

public class FileManager implements FileManagement {

    private final FileConnection connection;

    public FileManager(String filePath) {
        this.connection = new FileConnectionManager(filePath);
    }

    @Override
    public void save(Object dataset) {
        try {
            connection.save(dataset);
        } catch (IOException error) {
            throw new InputFileException("Fail writing on the file.");
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
}
