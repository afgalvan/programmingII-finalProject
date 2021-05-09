package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<K, T> {
    void create(T user, String userType) throws SQLException;

    ResultSet readAll() throws SQLException;

    ResultSet readById(K id) throws SQLException;

    void updateById(K id, T newData) throws SQLException;

    void deleteById(K id) throws SQLException;
}
