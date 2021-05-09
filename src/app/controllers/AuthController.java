package app.controllers;

import app.controllers.security.PasswordHandler;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.User;
import app.services.UserService;

/**
 * Class that controls all login validations and methods.
 */
public class AuthController implements Auth {

    private final UserController userController;
    private final UserService userService;

    public AuthController() {
        this.userService = new UserService();
        this.userController = new UserController();
    }

    /**
     * Authenticate the credentials given, by comparing them to the database.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return the response boolean from the user controller.
     */
    private boolean areValidCredentials(String username, String password) {
        User user = this.userController.getUserById(username);
        return (
            user != null && PasswordHandler.areEquals(password, user.getPassword())
        );
    }

    /**
     * Log in an user to use the application.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return A dialog response to be shown on the views.
     */
    @Override
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
    @Override
    public DialogResponse registerUser(
        String username,
        String password,
        int permission
    ) {
        password = PasswordHandler.encrypt(password);

        User newUser = (permission == 0)
            ? new Coordinator(username, password)
            : new SuperUser(username, password);

        if (userService.create(newUser).isError()) {
            return new DialogResponse(
                "Registro",
                "El usuario " + username + " ya se encuentra registrado",
                DialogResponse.ERROR_MESSAGE
            );
        }

        return new DialogResponse(
            "Registro",
            "El usuario " + username + " se registró con exito",
            DialogResponse.INFORMATION_MESSAGE
        );
    }
}
