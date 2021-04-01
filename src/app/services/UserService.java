package app.services;

import app.database.ConnectionManager;
import app.database.UserRepository;
import app.models.Coordinator;
import app.models.SuperUser;
import app.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {

    private final UserRepository userRepository;
    private final ConnectionManager connectionManager;

    public UserService() {
        this.connectionManager = new ConnectionManager();
        this.userRepository = new UserRepository(connectionManager);
    }

    @Override
    public Response<User> create(User user) {
        String userType = "SU";
        if (user instanceof Coordinator) {
            userType = "CO";
        }

        try {
            connectionManager.open();
            userRepository.create(user, userType);
            return new Response<>(user);
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public Response<User> read(User user) {
        try {
            connectionManager.open();
            ResultSet resultSet = userRepository.read(user);
            return new Response<>(resultSetMapToUser(resultSet));
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public Response<User> update(User original, User user) {
        try {
            connectionManager.open();
            userRepository.update(original, user);
            return new Response<>(user);
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public Response<User> delete(User user) {
        try {
            connectionManager.open();
            userRepository.delete(user);
            return new Response<>(user);
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    public Response<List<User>> readAll() {
        List<User> userList = new ArrayList<>();

        try {
            connectionManager.open();
            ResultSet resultSet = userRepository.readAll();
            while (resultSet.next()) {
                userList.add(resultSetMapToUser(resultSet));
            }

            return new Response<>(userList);
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    private User resultSetMapToUser(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");

        if (resultSet.getString("type").equals("SU")) {
            return new SuperUser(name, password);
        }
        return new Coordinator(name, password);
    }
}
