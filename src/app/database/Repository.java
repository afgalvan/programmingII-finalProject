package app.database;

import app.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<T> {
    void create(User user, String userType) throws SQLException;

    ResultSet read(T object) throws SQLException;

    void update(T object) throws SQLException;

    void delete(T object) throws SQLException;
}
