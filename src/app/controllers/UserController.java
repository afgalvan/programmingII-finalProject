package app.controllers;

import app.models.Response;
import app.models.annotations.TestedOn;
import app.models.users.User;
import app.services.IUserService;
import app.services.Service;
import app.services.UserService;
import java.util.List;
import java.util.function.Function;
import lombok.Getter;
import test.controllers.UserControllerTest;

/**
 * A class to control al user's CRUD processes.
 */
@Getter
@TestedOn(UserControllerTest.class)
public class UserController {

    private final IUserService userService;

    private final Function<String, String> postResponse = u ->
        u + " registrado con éxito.";

    private final Function<String, String> outpostResponse = u ->
        "No se pudo registrar el usuario " + u + ".";

    private static final UserController instance = new UserController();

    private UserController() {
        this.userService = new UserService();
    }

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public static UserController getInstance() {
        return instance;
    }

    /**
     * POST:
     * Save a given user object and save it to the database.
     *
     * @param user Any object that inheritance from the User class.
     * @return A string to show to the user
     */
    protected Response<User> postUser(User user) {
        Response<User> res = userService.insert(user);
        if (res.isError()) {
            return new Response<>(outpostResponse.apply(user.getName()));
        }

        return new Response<>(res.getData(), postResponse.apply(user.getName()));
    }

    /**
     * GET:
     * Get all the users previously registered from the database.
     *
     * @return A List of users all users from the database.
     */
    public List<User> getUsers() {
        Response<List<User>> res = userService.getAll();
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    /**
     * GET:
     * Get a User instance given his username from the database.
     *
     * @param username String value for the username.
     * @return Any kind of user depending of how was saved.
     */
    public User getUserById(String username) {
        Response<User> res = userService.getById(username);
        if (res.isError()) {
            return null;
        }
        return res.getData();
    }

    /**
     * POST:
     * Delete a determinate user given his username
     *
     * @param username String value for the username.
     * @return A message to be showed from the deleted status.
     */
    public String deleteUserById(String username) {
        Response<User> res = userService.deleteById(username);
        if (res.isError()) {
            return "No se pudo eliminar el usuario.";
        }
        return "Usuario eliminado con éxito.";
    }

    /**
     * PATCH:
     * Update a user credentials given his username and an object that contains
     * his new information to be saved on the database.
     *
     * @param username String value for the username.
     * @param newData  Username object which contains his new credentials.
     * @return A message to be showed from the updateById status.
     */
    public String updateUserById(String username, User newData) {
        Response<User> res = userService.updateById(username, newData);
        if (res.isError()) {
            return "No se pudo modificar el usuario.";
        }
        return "Datos del usuario actualizados.";
    }
}
