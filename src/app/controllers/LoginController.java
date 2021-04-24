package app.controllers;

import app.controllers.api.LocationApi;
import app.controllers.security.PasswordHandler;
import lombok.val;

/**
 * Class that controls all login validations and methods.
 */
public class LoginController {

    /**
     * Authenticate the credentials given, by comparing them to the database.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return the response boolean from the user controller.
     */
    private boolean areValidCredentials(String username, String password) {
        val userController = new UserController();
        val user = userController.getUserById(username);
        return user != null && PasswordHandler.areEquals(password, user.getPassword());
    }

    /**
     * Log in an user to use the application.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return A dialog response to be shown on the views.
     */
    public DialogResponse logUser(String username, String password) {
        if (areValidCredentials(username, password)) {
            return new DialogResponse(
                "Inicio de sesion",
                "Bienvenido " + username + "!",
                DialogResponse.INFORMATION_MESSAGE
            );
        }

        return new DialogResponse(
            "Inicio de sesion",
            "No se pudo validar los datos del usuario " + username + "!",
            DialogResponse.ERROR_MESSAGE
        );
    }

    /**
     * Register an user to application by saving it to the database.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return A dialog response to be shown on the views.
     */
    public DialogResponse registerUser(String username, String password) {
        return new DialogResponse(
            "Registro",
            //"El usuario " + username + " se registró con exito",
            LocationApi.getLastCity("Cesar"),
            DialogResponse.ERROR_MESSAGE
        );
    }
}
