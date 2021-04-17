package app.database;

import app.models.users.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to execute all CRUD queries for the Users to the database.
 */
public class UserRepository implements Repository<User, String> {

    private final ConnectionManager connection;

    public UserRepository(ConnectionManager connection) {
        this.connection = connection;
    }

    /**
     * Execute the query for saving an User instance.
     *
     * @param user     An instance of the User class to be saved.
     * @param userType A String that indicates which user types is
     * @throws SQLException When an username was already registered.
     */
    @Override
    public void create(User user, String userType) throws SQLException {
        String query = "INSERT INTO users (name, type, password) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, userType);
        statement.setString(3, user.getPassword());
        statement.execute();
    }

    /**
     * Execute the query for reading all users from the database.
     *
     * @return A resultSet containing all user's fields.
     * @throws SQLException When no users found.
     */
    @Override
    public ResultSet readAll() throws SQLException {
        String query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Obtain an user from the database from his username.
     *
     * @param username A string that represents his username.
     * @return A result set containing all his fields.
     * @throws SQLException When any username match.
     */
    @Override
    public ResultSet read(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        return statement.executeQuery();
    }

    /**
     * Update an user info from the database depending of his username.
     *
     * @param username A String to find the user by his name.
     * @param newData  An user object generated with his new information.
     * @throws SQLException For a syntax error on SQL.
     */
    @Override
    public void update(String username, User newData) throws SQLException {
        String query = "UPDATE users SET name = ?, password = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newData.getName());
        statement.setString(2, newData.getPassword());
        statement.setString(3, username);
        statement.executeUpdate();
    }

    /**
     * Deleting a user row from the database by looking for his username.
     *
     * @param username A String to find the user by his name.
     * @throws SQLException For a syntax error on SQL.
     */
    @Override
    public void delete(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.execute();
    }
}
