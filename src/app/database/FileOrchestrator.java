package app.database;

public interface FileOrchestrator {
    void save(Object data);

    Object read();
}
