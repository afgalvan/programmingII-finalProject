package test.controllers;

import app.controllers.UserController;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class UserControllerTest {

    public UserController userController = new UserController();
    public User sample = new Coordinator("Laika", "DeathAt2002");
    public SuperUser updateSample = new SuperUser("Xavier", "xmen-10");

    @Test
    @Order(order = 1)
    public void postTest() {
        Assert.assertEquals(
            userController.getPostResponse(),
            userController.postUser(sample)
        );
    }

    @Test
    @Order(order = 2)
    public void postDuplicateUser() {
        Assert.assertEquals(
            userController.getOutpostResponse() + sample.getName() + ".",
            userController.postUser(sample)
        );
    }

    @Test
    @Order(order = 3)
    public void getsTest() {
        Assert.assertNotNull(userController.getUsers());
    }

    @Test
    @Order(order = 4)
    public void getTest() {
        Assert.assertEquals(sample, userController.getUserById(sample.getName()));
    }

    @Test
    @Order(order = 5)
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
    @Order(order = 6)
    public void deleteTest() {
        Assert.assertEquals(
            "Usuario eliminado con éxito.",
            userController.deleteUserById(updateSample.getName())
        );
    }
}
