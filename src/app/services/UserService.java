package app.services;

import app.database.DBConnection;
import app.exceptions.DataAccessException;
import app.models.Response;
import app.models.annotations.TestedOn;
import app.models.users.User;
import app.repositories.Repository;
import app.repositories.UserRepository;
import java.sql.SQLException;
import java.util.List;
import test.services.UserServiceTest;

/**
 * Class that manages all business logic and database implementation.
 */
@TestedOn(UserServiceTest.class)
public class UserService implements Service<String, User> {

    private final Repository<String, User> userRepository;
    private final DBConnection DBConnection;

    public UserService() {
        this(new DBConnection());
    }

    public UserService(DBConnection DBConnection) {
        this.DBConnection = DBConnection;
        this.userRepository = new UserRepository(this.DBConnection);
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
            DBConnection.open();
            userRepository.insert(user);
            return new Response<>(user);
        } catch (SQLException | DataAccessException ignore) {
            return new Response<>();
        } finally {
            DBConnection.close();
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
            DBConnection.open();
            List<User> userList = userRepository.getAll();
            return new Response<>(userList);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnection.close();
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
            DBConnection.open();
            User user = userRepository.getById(username);
            return new Response<>(user);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnection.close();
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
            DBConnection.open();
            User user = userRepository.getById(username);
            userRepository.updateById(username, newData);
            return new Response<>(user);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnection.close();
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
            DBConnection.open();
            userRepository.deleteById(username);
            return new Response<>(username, false);
        } catch (Exception ignore) {
            return new Response<>();
        } finally {
            DBConnection.close();
        }
    }
}
