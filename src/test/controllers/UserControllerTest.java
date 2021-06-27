package test.controllers;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.controllers.UserController;
import app.models.users.Coordinator;
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
public class UserControllerTest {

    private UserController userController;
    private Auth authController;
    private User sample;
    private User updateSample;

    @Before
    public void setUp() {
        this.userController = UserController.getInstance();
        this.authController = AuthController.getInstance();
        this.sample = new Coordinator("Laika", "DeathAt2002");
        this.updateSample = new SuperUser("Xavier", "xmen-10");
    }

    @Test
    @Order(1)
    public void postTest() {
        Assert.assertEquals(
            DialogResponse.INFORMATION_MESSAGE,
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.CO)
                .getStatusCode()
        );
    }

    @Test
    @Order(2)
    public void postDuplicateUser() {
        Assert.assertEquals(
            DialogResponse.ERROR_MESSAGE,
            authController
                .registerUser(sample.getName(), sample.getPassword(), UserType.CO)
                .getStatusCode()
        );
    }

    @Test
    @Order(3)
    public void getsTest() {
        Assert.assertNotNull(userController.getUsers());
    }

    @Test
    @Order(4)
    public void getTest() {
        Assert.assertNotNull(userController.getUserById(sample.getName()));
    }

    @Test
    @Order(5)
    public void putTest() {
        Assert.assertNotNull(userController.getUserById(sample.getName()));
        Assert.assertEquals(
            "Datos del usuario actualizados.",
            userController.updateUserById(sample.getName(), updateSample)
        );
        Assert.assertNull(userController.getUserById(sample.getName()));
        sample = updateSample;
    }

    @Test
    @Order(6)
    public void deleteTest() {
        Assert.assertEquals(
            "Usuario eliminado con éxito.",
            userController.deleteUserById(updateSample.getName())
        );
    }
}
