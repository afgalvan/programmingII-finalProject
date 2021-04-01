package app.database;

import app.models.Coordinator;
import app.models.User;
import java.sql.*;

public class UserRepository implements Repository<User> {

    private final ConnectionManager connection;

    public UserRepository(ConnectionManager connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) throws SQLException {
        String query = "INSERT INTO users (name, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());
        statement.execute();
    }

    @Override
    public User read(User user) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        ResultSet resultSet = statement.executeQuery();
        return new Coordinator(
            resultSet.getString("name"),
            resultSet.getString("password")
        );
    }

    @Override
    public void update(User user) throws SQLException {
        String query = "UPDATE users ";
    }

    @Override
    public void delete(User user) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.execute();
    }
}
