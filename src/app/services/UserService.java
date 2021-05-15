package app.services;

import app.database.ConnectionManager;
import app.exceptions.DataAccessException;
import app.models.users.User;
import app.repositories.Repository;
import app.repositories.UserRepository;
import java.sql.SQLException;
import java.util.List;

/**
 * Class that manages all business logic and database implementation.
 */
public class UserService implements Service<String, User> {

    private final Repository<String, User> userRepository;
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
    public ServiceResponse<User> insert(User user) {
        try {
            connectionManager.open();
            userRepository.insert(user);
            return new ServiceResponse<>(user);
        } catch (SQLException | DataAccessException ignore) {
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
    public ServiceResponse<List<User>> getAll() {
        try {
            connectionManager.open();
            List<User> userList = userRepository.getAll();
            return new ServiceResponse<>(userList);
        } catch (Exception ignore) {
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
    public ServiceResponse<User> getById(String username) {
        try {
            connectionManager.open();
            User user = userRepository.getById(username);
            return new ServiceResponse<>(user);
        } catch (Exception ignore) {
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
            User user = userRepository.getById(username);
            userRepository.updateById(username, newData);
            return new ServiceResponse<>(user);
        } catch (Exception ignore) {
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
        } catch (Exception ignore) {
            return new ServiceResponse<>();
        } finally {
            connectionManager.close();
        }
    }
}
