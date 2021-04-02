package test.services;

import app.models.Coordinator;
import app.models.User;
import app.services.UserService;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    public UserService userService = new UserService();

    @Test
    public void userCreationTest() {
        User sample = new Coordinator("Maria", "Okiss123");
        userService.create(sample);
        Assert.assertEquals(
            userService.read(sample).getData().getName(),
            sample.getName()
        );
    }

    @Test
    public void saveCorrectUserType() {
        User sample = new Coordinator("Maria", "Okiss123");
        Assert.assertTrue(userService.read(sample).getData() instanceof Coordinator);
    }

    @Test
    public void readUserTest() {}

    @Test
    public void updateUserTest() {}

    @Test
    public void userDeletionTest() {
        User sample = new Coordinator("Maria", "Okiss123");
        userService.delete(sample);
        Assert.assertNull(userService.read(sample).getData());
    }

    @Test
    public void readAllUsers() {}
}
