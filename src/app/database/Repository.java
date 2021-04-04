package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<P, T> {
    void create(T user, String userType) throws SQLException;

    ResultSet readAll() throws SQLException;

    ResultSet read(P id) throws SQLException;

    void update(P id, T newData) throws SQLException;

    void delete(P id) throws SQLException;
}
