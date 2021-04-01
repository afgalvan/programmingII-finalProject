package app.database;

import java.sql.SQLException;

public interface DBRepository<T> {
    void create(T object) throws SQLException;

    T read(T object) throws SQLException;

    void update(T object);

    void delete(T object);
}
