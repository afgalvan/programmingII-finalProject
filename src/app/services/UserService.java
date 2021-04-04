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

public class UserService implements Service<String, User> {

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

    @Override
    public Response<User> read(String username) {
        try {
            connectionManager.open();
            ResultSet resultSet = userRepository.read(username);
            return new Response<>(resultSetMapToUser(resultSet));
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public Response<User> update(String username, User newData) {
        try {
            connectionManager.open();
            userRepository.update(username, newData);
            ResultSet user = userRepository.read(username);
            return new Response<>(resultSetMapToUser(user));
        } catch (SQLException ignore) {
            return new Response<>();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public Response<User> delete(String username) {
        try {
            connectionManager.open();
            userRepository.delete(username);
            return new Response<>();
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
