package app.database;

public interface IFileComposer {
    void save(Object data);

    Object read();
}
