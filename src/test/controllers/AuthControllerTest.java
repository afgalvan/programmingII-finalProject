package test.controllers;

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

    public AuthController authController;
    public UserController controller;
    public User sample;

    @Before
    public void setUp() {
        authController = new AuthController();
        controller = new UserController();
        sample = new SuperUser("+uvaBxdt3ssCJXCr4Huvw==", "xmen-10-------");
    }

    @Test
    @Order(order = 1)
    public void logInvalidUser() {
        Assert.assertEquals(
            DialogResponse.ERROR_MESSAGE,
            authController.loginUser(sample.getName(), sample.getPassword()).getType()
        );
    }

    @Test
    @Order(order = 2)
    public void registerUser() {
        Assert.assertEquals(
            DialogResponse.INFORMATION_MESSAGE,
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.CO)
                .getType()
        );
    }

    @Test
    @Order(order = 3)
    public void registerInvalidUser() {
        Assert.assertEquals(
            DialogResponse.ERROR_MESSAGE,
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.SU)
                .getType()
        );
    }

    @Test
    @Order(order = 4)
    public void logInUser() {
        Assert.assertEquals(
            DialogResponse.INFORMATION_MESSAGE,
            authController.loginUser(sample.getName(), sample.getPassword()).getType()
        );
    }

    @Test
    @Order(order = 5)
    public void cleanUp() {
        controller.deleteUserById(sample.getName());
    }
}
