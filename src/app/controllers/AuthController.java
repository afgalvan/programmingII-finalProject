package app.controllers;

import app.controllers.security.PasswordHandler;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.User;
import app.models.users.UserType;
import app.services.UserService;

/**
 * Class that controls all login validations and methods.
 */
public class AuthController implements Auth {

    private final UserController userController;
    private final UserService userService;
    private User currentUser;

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
        currentUser = this.userController.getUserById(username);
        return (
            currentUser != null &&
            PasswordHandler.areEquals(
                password,
                currentUser.getPassword(),
                currentUser.getSalt()
            )
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
    public DialogResponse<User> loginUser(String username, String password) {
        if (!areValidCredentials(username, password)) {
            return new DialogResponse<>(
                "Inicio de sesion",
                "No se pudo validar los datos del usuario " + username + "!",
                DialogResponse.ERROR_MESSAGE
            );
        }

        return new DialogResponse<>(
            "Inicio de sesion",
            "Bienvenido " + username + "!",
            DialogResponse.INFORMATION_MESSAGE,
            this.currentUser
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
    public DialogResponse<User> registerUser(
        String username,
        String password,
        UserType permission
    ) {
        String salt = PasswordHandler.generateSalt();
        String encryptPassword = PasswordHandler.encrypt(password, salt);

        User newUser = (permission == UserType.CO)
            ? new Coordinator(username, encryptPassword, salt)
            : new SuperUser(username, encryptPassword, salt);

        if (userService.create(newUser).isError()) {
            return new DialogResponse<>(
                "Registro",
                "El usuario " + username + " ya se encuentra registrado",
                DialogResponse.ERROR_MESSAGE
            );
        }

        return new DialogResponse<>(
            "Registro",
            "El usuario " + username + " se registró con exito",
            DialogResponse.INFORMATION_MESSAGE
        );
    }
}
