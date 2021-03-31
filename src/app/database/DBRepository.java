package app.database;

public interface DBRepository<T> {
    boolean create(T object);

    T read(T object);

    boolean update(T object);

    boolean delete(T object);
}
