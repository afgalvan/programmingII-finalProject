package app.database;

import app.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUser extends DBAccess implements IInsert<User> {

    @Override
    public boolean insert(User user) {
        open();
        try (PreparedStatement statement = prepareStatement(
            "INSERT INTO User (name, password) VALUES (?, ?)")){
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            return !statement.execute();
        } catch (SQLException throwables) {
            return false;
        } finally {
            close();
        }
    }
}
