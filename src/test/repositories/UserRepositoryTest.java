package test.repositories;

import app.database.DBConnection;
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
    public static DBConnection DBConnection = new DBConnection(URL_TEST);
    public UserRepository userRepository = new UserRepository(DBConnection);

    @SneakyThrows
    @Test
    public void connectionTest() {
        try {
            DBConnection.open();
            Assert.assertNotNull(DBConnection.get_connection());

            Connection expected = DriverManager.getConnection(DBConnection.getUrl());
            Assert.assertEquals(
                expected.getSchema(),
                DBConnection.get_connection().getSchema()
            );
        } catch (SQLException | NullPointerException ignore) {
            Assert.assertNull(DBConnection.get_connection());
        } finally {
            DBConnection.close();
        }
    }

    @Test
    public void createUserTest() {
        User sample = new SuperUser("Joe", "Password123", "Some salt");

        try {
            DBConnection.open();
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
            DBConnection.close();
        }
    }
}
