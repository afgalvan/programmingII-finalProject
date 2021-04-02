package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<T> {
    void create(T user, String userType) throws SQLException;

    ResultSet read(T object) throws SQLException;

    void update(T originalData, T newData) throws SQLException;

    void delete(T object) throws SQLException;

    ResultSet readAll() throws SQLException;
}
