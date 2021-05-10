package test.database;

import app.database.ConnectionManager;
import app.models.users.SuperUser;
import app.models.users.User;
import app.repositories.UserRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class UserRepositoryTest {

    public static final String URL_TEST =
        "jdbc:sqlite:./src/test/database/test.sqlite";
    public static ConnectionManager connectionManager = new ConnectionManager(
        URL_TEST
    );
    public UserRepository userRepository = new UserRepository(connectionManager);

    @SneakyThrows
    @Test
    public void connectionTest() {
        try {
            connectionManager.open();
            Assert.assertNotNull(connectionManager.getConnection());

            Connection expected = DriverManager.getConnection(
                connectionManager.getUrl()
            );
            Assert.assertEquals(
                expected.getSchema(),
                connectionManager.getConnection().getSchema()
            );
        } catch (SQLException | NullPointerException ignore) {
            Assert.assertNull(connectionManager.getConnection());
        } finally {
            connectionManager.close();
        }
    }

    @Test
    public void createUserTest() {
        User sample = new SuperUser("Joe", "Password123");

        try {
            connectionManager.open();
            userRepository.create(sample);
        } catch (SQLException ignored) {}

        try {
            Assert.assertEquals(
                sample.getName(),
                userRepository.readById("Joe").getName()
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionManager.close();
        }
    }

    @Test
    public void readAllUsersTest() {}

    @Test
    public void readUserTest() {}

    @Test
    public void updateUserTest() {}

    @Test
    public void deleteUserTest() {}
}
