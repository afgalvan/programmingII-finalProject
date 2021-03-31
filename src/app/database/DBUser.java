package app.database;

import app.models.Coordinator;
import app.models.SuperUser;
import app.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser extends DBConnection implements DataOperations<User> {

    @Override
    public boolean create(User user) {
        open();
        try (
            PreparedStatement statement = prepareStatement(
                "SELECT FROM user (name, password) VALUES (?, ?)"
            )
        ) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            return !statement.execute();
        } catch (SQLException throwables) {
            return false;
        } finally {
            close();
        }
    }

    @Override
    public User read(User user) {
        open();
        try (
            PreparedStatement statement = prepareStatement("SELECT * FROM user")
        ) {
            ResultSet query = statement.getResultSet();
            if (query.getString("type").equals("SuperUser")) {
                return new SuperUser(
                    query.getString("name"),
                    query.getString("password")
                );
            }
            return new Coordinator(
                query.getString("name"),
                query.getString("password")
            );
        } catch (SQLException throwables) {
            return null;
        } finally {
            close();
        }
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        open();
        try (
            PreparedStatement statement = prepareStatement(
                "DELETE FROM user WHERE name = ?"
            )
        ) {
            statement.setString(1, user.getName());

            return !statement.execute();
        } catch (SQLException throwables) {
            return false;
        } finally {
            close();
        }
    }
}
