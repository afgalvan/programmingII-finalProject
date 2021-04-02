package app.database;

import app.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository implements Repository<User> {

    private final ConnectionManager connection;

    public UserRepository(ConnectionManager connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user, String userType) throws SQLException {
        String query = "INSERT INTO users (name, type, password) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, userType);
        statement.setString(3, user.getPassword());
        statement.execute();
    }

    @Override
    public ResultSet read(User user) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        return statement.executeQuery();
    }

    @Override
    public void update(User original, User newData) throws SQLException {
        String query = "UPDATE users SET name = ?, password = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newData.getName());
        statement.setString(2, newData.getPassword());
        statement.setString(3, original.getName());
        statement.executeUpdate();
    }

    @Override
    public void delete(User user) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.execute();
    }

    @Override
    public ResultSet readAll() throws SQLException {
        String query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}