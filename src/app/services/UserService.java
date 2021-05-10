package app.services;

import app.database.ConnectionManager;
import app.models.users.User;
import app.repositories.UserRepository;
import java.sql.SQLException;
import java.util.List;

/**
 * Class that manages all business logic and database implementation.
 */
public class UserService implements Service<String, User> {

    private final UserRepository userRepository;
    private final ConnectionManager connectionManager;

    public UserService() {
        this(new ConnectionManager());
    }

    public UserService(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        this.userRepository = new UserRepository(this.connectionManager);
    }

    /**
     * Save a given User instance to the database.
     *
     * @param user Any object that inheritance from the User class.
     * @return A response depending on the success of the action.
     */
    @Override
    public ServiceResponse<User> create(User user) {
        try {
            connectionManager.open();
            userRepository.create(user);
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
        try {
            connectionManager.open();
            List<User> userList = userRepository.readAll();
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
    public ServiceResponse<User> readById(String username) {
        try {
            connectionManager.open();
            User user = userRepository.readById(username);
            return new ServiceResponse<>(user);
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
    public ServiceResponse<User> updateById(String username, User newData) {
        try {
            connectionManager.open();
            User user = userRepository.readById(username);
            userRepository.updateById(username, newData);
            return new ServiceResponse<>(user);
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
    public ServiceResponse<User> deleteById(String username) {
        try {
            connectionManager.open();
            userRepository.deleteById(username);
            return new ServiceResponse<>(username, false);
        } catch (SQLException ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }
}
