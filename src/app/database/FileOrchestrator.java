package app.database;

public interface FileOrchestrator<T> {
    void save(T data);
    T read();
}
