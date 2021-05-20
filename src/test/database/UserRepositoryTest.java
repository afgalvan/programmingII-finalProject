package test.database;

import app.database.DBConnectionManager;
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

    public static final String URL_TEST = "jdbc:sqlite:./src/test/database/test.sqlite";
    public static DBConnectionManager DBConnectionManager = new DBConnectionManager(
        URL_TEST
    );
    public UserRepository userRepository = new UserRepository(DBConnectionManager);

    @SneakyThrows
    @Test
    public void connectionTest() {
        try {
            DBConnectionManager.open();
            Assert.assertNotNull(DBConnectionManager.get_connection());

            Connection expected = DriverManager.getConnection(
                DBConnectionManager.getUrl()
            );
            Assert.assertEquals(
                expected.getSchema(),
                DBConnectionManager.get_connection().getSchema()
            );
        } catch (SQLException | NullPointerException ignore) {
            Assert.assertNull(DBConnectionManager.get_connection());
        } finally {
            DBConnectionManager.close();
        }
    }

    @Test
    public void createUserTest() {
        User sample = new SuperUser("Joe", "Password123", "Some salt");

        try {
            DBConnectionManager.open();
            userRepository.insert(sample);
        } catch (SQLException ignored) {}

        try {
            Assert.assertEquals(
                sample.getName(),
                userRepository.getById("Joe").getName()
            );
            userRepository.deleteById(sample.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnectionManager.close();
        }
    }
}
