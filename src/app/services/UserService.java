package app.services;

import app.database.ConnectionManager;
import app.database.UserRepository;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages all business logic and database implementation.
 */
public class UserService implements Service<User, String> {

    private final UserRepository userRepository;
    private final ConnectionManager connectionManager;

    public UserService() {
        this.connectionManager = new ConnectionManager();
        this.userRepository = new UserRepository(connectionManager);
    }

    /**
     * Save a given User instance to the database.
     *
     * @param user Any object that inheritance from the User class.
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<User> create(User user) {
        String userType = "SU";
        if (user instanceof Coordinator) {
            userType = "CO";
        }

        try {
            connectionManager.open();
            userRepository.create(user, userType);
            return new ServiceResponse<>(user);
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }

    /**
     * Obtain all the users from the database.
     *
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<List<User>> readAll() {
        List<User> userList = new ArrayList<>();

        try {
            connectionManager.open();
            ResultSet resultSet = userRepository.readAll();
            while (resultSet.next()) {
                userList.add(resultSetMapToUser(resultSet));
            }

            return new ServiceResponse<>(userList);
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }

    /**
     * Find an user from the database from his given username.
     *
     * @param username A String to find the user by his name.
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<User> read(String username) {
        try {
            connectionManager.open();
            ResultSet resultSet = userRepository.read(username);
            return new ServiceResponse<>(resultSetMapToUser(resultSet));
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }

    /**
     * Update an user info from the database depending of his username.
     *
     * @param username A String to find the user by his name.
     * @param newData  An user object generated with his new information.
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<User> update(String username, User newData) {
        try {
            connectionManager.open();
            ResultSet user = userRepository.read(username);
            userRepository.update(username, newData);
            return new ServiceResponse<>(resultSetMapToUser(user));
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }

    /**
     * Deleting a user row from the database by looking for his username.
     *
     * @param username A String to find the user by his name.
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<User> delete(String username) {
        try {
            connectionManager.open();
            userRepository.delete(username);
            return new ServiceResponse<>(username);
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
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

        if (resultSet.getString("type").equals("SU")) {
            return new SuperUser(name, password);
        }
        return new Coordinator(name, password);
    }
}
