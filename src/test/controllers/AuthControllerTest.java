package test.controllers;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.controllers.UserController;
import app.models.users.SuperUser;
import app.models.users.User;
import app.models.users.UserType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class AuthControllerTest {

    public Auth authController;
    public UserController controller;
    public User sample;

    @Before
    public void setUp() {
        authController = AuthController.getInstance();
        controller = UserController.getInstance();
        sample = new SuperUser("+uvaBxdt3ssCJXCr4Huvw==", "xmen-10-------");
    }

    @Test
    @Order(1)
    public void logInvalidUser() {
        Assert.assertTrue(
            "A unregistered user shouldn't be allowed to log in.",
            authController.loginUser(sample.getName(), sample.getPassword()).isError()
        );
    }

    @Test
    @Order(2)
    public void registerUser() {
        Assert.assertFalse(
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.CO)
                .isError()
        );
    }

    @Test
    @Order(3)
    public void registerInvalidUser() {
        Assert.assertTrue(
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.SU)
                .isError()
        );
    }

    @Test
    @Order(4)
    public void logInUser() {
        Assert.assertFalse(
            authController.loginUser(sample.getName(), sample.getPassword()).isError()
        );
    }

    @Test
    @Order(5)
    public void cleanUp() {
        controller.deleteUserById(sample.getName());
    }
}
