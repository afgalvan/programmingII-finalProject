package app.services;

import app.database.DBConnectionManager;
import app.exceptions.DataAccessException;
import app.models.Response;
import app.models.annotations.Testable;
import app.models.users.User;
import app.repositories.Repository;
import app.repositories.UserRepository;
import java.sql.SQLException;
import java.util.List;
import test.services.UserServiceTest;

/**
 * Class that manages all business logic and database implementation.
 */
@Testable(testClass = UserServiceTest.class)
public class UserService implements Service<String, User> {

    private final Repository<String, User> userRepository;
    private final DBConnectionManager DBConnectionManager;

    public UserService() {
        this(new DBConnectionManager());
    }

    public UserService(DBConnectionManager DBConnectionManager) {
        this.DBConnectionManager = DBConnectionManager;
        this.userRepository = new UserRepository(this.DBConnectionManager);
    }

    /**
     * Save a given User instance to the database.
     *
     * @param user Any object that inheritance from the User class.
     * @return A response depending on the success of the action.
     */
    @Override
    public Response<User> insert(User user) {
        try {
            DBConnectionManager.open();
            userRepository.insert(user);
            return new Response<>(user);
        } catch (SQLException | DataAccessException ignore) {
            return new Response<>();
        } finally {
            DBConnectionManager.close();
        }
    }

    /**
     * Obtain all the users from the database.
     *
     * @return A response depending on the success of the action.
     */
    @Override
    public Response<List<User>> getAll() {
        try {
            DBConnectionManager.open();
            List<User> userList = userRepository.getAll();
            return new Response<>(userList);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnectionManager.close();
        }
    }

    /**
     * Find an user from the database from his given username.
     *
     * @param username A String to find the user by his name.
     * @return A response depending on the success of the action.
     */
    @Override
    public Response<User> getById(String username) {
        try {
            DBConnectionManager.open();
            User user = userRepository.getById(username);
            return new Response<>(user);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnectionManager.close();
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
    public Response<User> updateById(String username, User newData) {
        try {
            DBConnectionManager.open();
            User user = userRepository.getById(username);
            userRepository.updateById(username, newData);
            return new Response<>(user);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnectionManager.close();
        }
    }

    /**
     * Deleting a user row from the database by looking for his username.
     *
     * @param username A String to find the user by his name.
     * @return A response depending on the success of the action.
     */
    @Override
    public Response<User> deleteById(String username) {
        try {
            DBConnectionManager.open();
            userRepository.deleteById(username);
            return new Response<>(username, false);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnectionManager.close();
        }
    }
}
