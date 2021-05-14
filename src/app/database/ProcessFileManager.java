package app.database;

import app.models.Process;
import java.io.IOException;
import java.util.Map;

public class ProcessFileManager implements FileOrchestrator<Map<Long, Process>> {

    private final FileHandler<Map<Long, Process>> connection;

    public ProcessFileManager(String filePath) {
        this.connection = new FileConnectionManager<>(filePath);
    }

    public ProcessFileManager() {
        this.connection = new FileConnectionManager<>("src/app/database/Process.obj");
    }

    @Override
    public void save(Map<Long, Process> dataset) {
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
    public Map<Long, Process> read() {
        try {
            return (Map<Long, Process>) connection.read();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (IOException ignored) {}
        }
    }
}
