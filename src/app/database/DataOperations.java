package app.database;

public interface DataOperations<T> {
    boolean create(T object);
    T read(T object);
    boolean update(T object);
    boolean delete(T object);
}
