package test.services;

import app.models.users.Coordinator;
import app.models.users.User;
import app.services.UserService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class UserServiceTest {

    public UserService userService = new UserService();
    public User sample = new Coordinator("Maria", "Okiss123");
    public User updateSample = new Coordinator("María", "Okiss123");

    @Test
    @Order(order = 1)
    public void userCreationTest() {
        userService.create(sample);
        Assert.assertEquals(
            userService.readById("Maria").getData().getName(),
            sample.getName()
        );
    }

    @Test
    @Order(order = 2)
    public void saveCorrectUserType() {
        if (userService.readById("Maria").getData() == null) {
            userService.create(sample);
        }

        Assert.assertTrue(
            userService.readById("Maria").getData() instanceof Coordinator
        );
    }

    @Test
    @Order(order = 3)
    public void readAllUsers() {
        Assert.assertTrue(userService.readAll().getData() instanceof List);
        Assert.assertFalse(userService.readAll().isError());
    }

    @Test
    @Order(order = 4)
    public void readUserTest() {
        Assert.assertFalse(userService.readById("Maria").isError());
    }

    @Test
    @Order(order = 5)
    public void readBadUserTest() {
        Assert.assertTrue(userService.readById("xadacsa31$#").isError());
    }

    @Test
    @Order(order = 6)
    public void updateBadUserTest() {
        Assert.assertTrue(userService.updateById("x1dsadassas", sample).isError());
    }

    @Test
    @Order(order = 7)
    public void updateUser() {
        Assert.assertFalse(userService.readById("Maria").isError());
        Assert.assertFalse(
            userService.updateById(sample.getName(), updateSample).isError()
        );
    }

    @Test
    @Order(order = 8)
    public void userDeletionTest() {
        userService.deleteById(updateSample.getName());
        Assert.assertNull(userService.readById(updateSample.getName()).getData());
    }
}
