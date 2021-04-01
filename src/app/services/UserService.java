package app.services;

import app.database.ConnectionManager;
import app.database.UserRepository;
import app.models.Coordinator;
import app.models.SuperUser;
import app.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");

            if (resultSet.getString("type").equals("SU")) {
                return new Response<>(new SuperUser(name, password));
            }
            return new Response<>(new Coordinator(name, password));
        } catch (SQLException ignore) {
            return new Response<>();
        }
    }

    @Override
    public boolean update(User data) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
