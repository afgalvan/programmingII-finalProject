package app.controllers;

import app.models.User;
import app.services.ServiceResponse;
import app.services.UserService;
import java.util.List;
import lombok.Getter;

/**
 * A class to control al user's CRUD processes.
 */
@Getter
public class UserController {

    private final UserService userService;
    private final String postResponse = "Usuario registrado con éxito.";
    private final String outpostResponse = "No se pudo registrar el usuario ";

    public UserController() {
        this.userService = new UserService();
    }

    /**
     * POST:
     * Save a given user object and save it to the database.
     *
     * @param user Any object that inheritance from the User class.
     * @return A string to show to the user
     */
    public String postUser(User user) {
        ServiceResponse<User> res = userService.create(user);
        if (res.isError()) {
            return outpostResponse + user.getName() + ".";
        }
        return postResponse;
    }

    /**
     * GET:
     * Get all the users previously registered from the database.
     *
     * @return A List of users all users from the database.
     */
    public List<User> getUsers() {
        /* TODO: Differentiate between an error and an empty database
         * TODO: Return a message to show.
         */
        ServiceResponse<List<User>> res = userService.readAll();
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
        ServiceResponse<User> res = userService.read(username);
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
        ServiceResponse<User> res = userService.delete(username);
        if (res.isError()) {
            return "Error inesperado.";
        }
        return "Usuario eliminado con éxito.";
    }

    /**
     * PUT:
     * Update a user credentials given his username and an object that contains
     * his new information to be saved on the database.
     *
     * @param username String value for the username.
     * @param newData  Username object which contains his new credentials.
     * @return A message to be showed from the update status.
     */
    public String updateUserById(String username, User newData) {
        ServiceResponse<User> res = userService.update(username, newData);
        if (res.isError()) {
            return "No se pudo modificar el usuario.";
        }
        return "Datos del usuario actualizados.";
    }
}
