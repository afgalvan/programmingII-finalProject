package app.database;

import java.sql.SQLException;

public interface Repository<T> {
    void create(T object) throws SQLException;

    T read(T object) throws SQLException;

    void update(T object) throws SQLException;

    void delete(T object) throws SQLException;
}
