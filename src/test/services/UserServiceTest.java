package test.services;

import app.models.Coordinator;
import app.models.User;
import app.services.UserService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    public UserService userService = new UserService();
    public User sample = new Coordinator("Maria", "Okiss123");

    @Test
    public void userCreationTest() {
        userService.create(sample);
        Assert.assertEquals(
            userService.read("Maria").getData().getName(),
            sample.getName()
        );
    }

    @Test
    public void saveCorrectUserType() {
        Assert.assertTrue(
            userService.read("Maria").getData() instanceof Coordinator
        );
    }

    @Test
    public void readAllUsers() {
        Assert.assertTrue(userService.readAll().getData() instanceof List);
        Assert.assertFalse(userService.readAll().isError());
    }

    @Test
    public void readUserTest() {
        Assert.assertFalse(userService.read("Maria").isError());
    }

    @Test
    public void readBadUserTest() {
        Assert.assertTrue(userService.read("xadacsdfasdf231$#").isError());
    }

    @Test
    public void updateBadUserTest() {
        Assert.assertTrue(userService.update("x1dsadassdasdas", sample).isError());
    }

    @Test
    public void userDeletionTest() {
        userService.delete("Maria");
        Assert.assertNull(userService.read("Maria").getData());
    }
}
