package app.repositories;

import app.database.DBConnection;
import app.models.annotations.TestedOn;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.val;
import test.repositories.SQLiteUserRepositoryTest;

/**
 * Class to execute all CRUD queries for the Users to the database.
 */
@TestedOn(SQLiteUserRepositoryTest.class)
public class SQLiteUserRepository implements UserRepository {

    private final DBConnection connection;

    public SQLiteUserRepository(DBConnection connection) {
        this.connection = connection;
    }

    /**
     * Execute the query for saving an User instance.
     *
     * @param user An instance of the User class to be saved.
     * @throws SQLException When an username was already registered.
     */
    @Override
    public void insert(User user) throws SQLException {
        val query = "INSERT INTO users (name, type, password, salt) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, (user instanceof SuperUser) ? "SU" : "CO");
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getSalt());
        statement.execute();
    }

    /**
     * Execute the query for reading all users from the database.
     *
     * @return A resultSet containing all user's fields.
     * @throws SQLException When no users found.
     */
    @Override
    public List<User> getAll() throws SQLException {
        val query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        val userList = new ArrayList<User>();
        while (resultSet.next()) {
            userList.add(resultSetMapToUser(resultSet));
        }

        return userList;
    }

    /**
     * Obtain an user from the database from his username.
     *
     * @param username A string that represents his username.
     * @return A result set containing all his fields.
     * @throws SQLException When any username match.
     */
    @Override
    public User getById(String username) throws SQLException {
        val query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        return resultSetMapToUser(statement.executeQuery());
    }

    /**
     * Update an user info from the database depending of his username.
     *
     * @param username A String to find the user by his name.
     * @param newData  An user object generated with his new information.
     * @throws SQLException For a syntax error on SQL.
     */
    @Override
    public boolean updateById(String username, User newData) throws SQLException {
        val query = "UPDATE users SET name = ?, password = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newData.getName());
        statement.setString(2, newData.getPassword());
        statement.setString(3, username);
        statement.executeUpdate();

        return true;
    }

    /**
     * Deleting a user row from the database by looking for his username.
     *
     * @param username A String to find the user by his name.
     * @throws SQLException For a syntax error on SQL.
     */
    @Override
    public boolean deleteById(String username) throws SQLException {
        val query = "DELETE FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.execute();

        return true;
    }

    /**
     * Convert a given result set from the database to a determinate user instance
     * depending of his saved type.
     *
     * @param resultSet A ResultSet from the database.
     * @return A user object generated from the database result set.
     * @throws SQLException For invalid fields.
     */
    private User resultSetMapToUser(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String salt = resultSet.getString("salt");

        if (resultSet.getString("type").equals("SU")) {
            return new SuperUser(name, password, salt);
        }
        return new Coordinator(name, password, salt);
    }
}
