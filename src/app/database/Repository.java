package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<K, T> {
    void create(T user, String userType) throws SQLException;

    ResultSet readAll() throws SQLException;

    ResultSet read(K id) throws SQLException;

    void update(K id, T newData) throws SQLException;

    void delete(K id) throws SQLException;
}
