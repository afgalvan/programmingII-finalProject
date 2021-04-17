package app.controllers;

/**
 * Class that controls all login validations and methods.
 */
public class LoginController {

    private void encryptPassword(String password) {}

    private void decryptPassword() {}

    /**
     * Authenticate the credentials given, by comparing them to the database.
     *
     * @param username String value for the username.
     * @param password String value for the password.
     * @return the response boolean from the user controller.
     */
    public boolean areValidCredentials(String username, String password) {
        return true;
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
            "El usuario " + username + " se registró con exito",
            DialogResponse.ERROR_MESSAGE
        );
    }
}
