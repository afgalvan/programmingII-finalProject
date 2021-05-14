package app.database;

import java.io.IOException;

public class ProcessFileManager implements FileOrchestrator {

    private final FileHandler connection;

    public ProcessFileManager(String filePath) {
        this.connection = new FileConnectionManager(filePath);
    }

    public ProcessFileManager() {
        this.connection = new FileConnectionManager("src/app/database/Process.obj");
    }

    @Override
    public void save(Object dataset) {
        try {
            connection.save(dataset);
        } catch (IOException error) {
            throw new NullPointerException("Fail writing on the file.");
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
