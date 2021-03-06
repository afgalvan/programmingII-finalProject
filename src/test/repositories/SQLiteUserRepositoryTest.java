package test.repositories;

import app.database.DBConnection;
import app.database.SQLiteConnection;
import app.exceptions.DataAccessException;
import app.models.users.SuperUser;
import app.models.users.User;
import app.repositories.SQLiteUserRepository;
import app.repositories.UserRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class SQLiteUserRepositoryTest {

    public static final String TEST_URI = "jdbc:sqlite:./src/test/database/test.sqlite";
    public static DBConnection DBConnector = new SQLiteConnection(TEST_URI);
    public UserRepository userRepository = new SQLiteUserRepository(DBConnector);

    @SneakyThrows
    @Test
    public void connectionTest() {
        try {
            DBConnector.open();
            Assert.assertNotNull(DBConnector.getConnection());

            Connection expected = DriverManager.getConnection(DBConnector.getUrl());
            Assert.assertEquals(
                expected.getSchema(),
                DBConnector.getConnection().getSchema()
            );
        } catch (SQLException | NullPointerException ignore) {
            Assert.assertNull(DBConnector.getConnection());
        } finally {
            DBConnector.close();
        }
    }

    @Test
    public void createUserTest() {
        User sample = new SuperUser("Joe", "Password123", "Some salt");

        try {
            DBConnector.open();
            userRepository.insert(sample);
        } catch (SQLException | DataAccessException | IOException ignored) {}

        try {
            Assert.assertEquals(
                sample.getName(),
                userRepository.getById("Joe").getName()
            );
            userRepository.deleteById(sample.getName());
        } catch (SQLException | DataAccessException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBConnector.close();
            } catch (IOException ignored) {}
        }
    }
}
