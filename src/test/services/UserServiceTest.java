package test.services;

import app.models.Response;
import app.models.users.Coordinator;
import app.models.users.User;
import app.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;
import test.repositories.SQLiteUserRepositoryTest;

@RunWith(OrderedRunner.class)
public class UserServiceTest {

    public UserService userService = new UserService(
        SQLiteUserRepositoryTest.DBConnector
    );
    public User sample = new Coordinator("Maria", "Okiss123", "SomeSalt");
    public User updateSample = new Coordinator("María", "Okiss123", "SomeSalt");

    @Test
    @Order(0)
    public void createUserWithoutSalt() {
        Response<User> response = userService.insert(
            new Coordinator("NoSaltUser", "NoSaltUser")
        );
        Assert.assertTrue("Users without salt should'nt be saved", response.isError());
    }

    @Test
    @Order(1)
    public void userCreationTest() {
        userService.insert(sample);
        Response<User> response = userService.getById(sample.getName());

        Assert.assertFalse(response.isError());
        Assert.assertNotNull(response.getData());
        Assert.assertEquals(response.getData().getName(), sample.getName());
    }

    @Test
    @Order(2)
    public void saveCorrectUserType() {
        if (userService.getById("Maria").getData() == null) {
            userService.insert(sample);
        }

        Assert.assertTrue(userService.getById("Maria").getData() instanceof Coordinator);
    }

    @Test
    @Order(3)
    public void readAllUsersTest() {
        Assert.assertNotNull(userService.getAll().getData());
        Assert.assertFalse(userService.getAll().isError());
    }

    @Test
    @Order(4)
    public void readUserTest() {
        Assert.assertFalse(userService.getById("Maria").isError());
    }

    @Test
    @Order(5)
    public void readBadUserTest() {
        Assert.assertTrue(userService.getById("xadacsa31$#").isError());
    }

    @Test
    @Order(6)
    public void updateBadUserTest() {
        Assert.assertTrue(userService.updateById("x1dsadassas", sample).isError());
    }

    @Test
    @Order(7)
    public void updateUserTest() {
        Assert.assertFalse(userService.getById("Maria").isError());
        Assert.assertFalse(
            userService.updateById(sample.getName(), updateSample).isError()
        );
    }

    @Test
    @Order(8)
    public void userDeletionTest() {
        userService.deleteById(updateSample.getName());
        Assert.assertNull(userService.getById(updateSample.getName()).getData());
    }
}
