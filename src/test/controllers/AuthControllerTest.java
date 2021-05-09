package test.controllers;

import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.controllers.UserController;
import app.models.users.SuperUser;
import app.models.users.User;
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
        sample = new SuperUser("+uvxxdMWt3ssCJXCr4Huvw==", "xmen-10-------");
    }

    @Test
    @Order(order = 1)
    public void logInvalidUser() {
        Assert.assertEquals(
            authController.logUser(sample.getName(), sample.getPassword()).getType(),
            DialogResponse.ERROR_MESSAGE
        );
    }

    @Test
    @Order(order = 2)
    public void registerUser() {
        Assert.assertEquals(
            authController
                .registerUser(sample.getName(), sample.getPassword(), 0)
                .getType(),
            DialogResponse.INFORMATION_MESSAGE
        );
    }

    @Test
    @Order(order = 3)
    public void registerInvalidUser() {
        Assert.assertEquals(
            authController
                .registerUser(sample.getName(), sample.getPassword(), 1)
                .getType(),
            DialogResponse.ERROR_MESSAGE
        );
    }

    @Test
    @Order(order = 4)
    public void logInUser() {
        Assert.assertEquals(
            authController.logUser(sample.getName(), sample.getPassword()).getType(),
            DialogResponse.INFORMATION_MESSAGE
        );
    }

    @Test
    @Order(order = 5)
    public void cleanUp() {
        controller.deleteUserById(sample.getName());
    }
}
