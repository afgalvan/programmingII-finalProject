package app.views.components.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.models.users.User;
import app.models.users.UserType;
import app.views.Window;
import lombok.Setter;

import java.awt.event.ActionListener;

@Setter
public class LoginForm extends AuthForm {

    private Auth authController;

    public LoginForm(Window window) {
        super("Inciar sesión", window);
        this.authController = AuthController.getInstance();
        setButtonActions();
    }

    private boolean isInvalidUsername(String username) {
        if (username.equals(this.usernamePlaceholder)) {
            new LoginDialog(window, new DialogResponse<>("Iniciar sesión", "Nombre de usuario inválido"));
            return true;
        }

        return false;
    }

    private ActionListener signIn() {
        return evt -> {
            String username = this.usernameField.getText();
            if (isInvalidUsername(username)) {
                return;
            }

            DialogResponse<User> response = authController.loginUser(
                username,
                String.valueOf(passwordField.getPassword())
            );
            new LoginDialog(window, response);
        };
    }

    private ActionListener singUp() {
        return evt -> {
            String username = this.usernameField.getText();
            if (isInvalidUsername(username)) {
                return;
            }

            DialogResponse<User> response = authController.registerUser(
                username,
                String.valueOf(passwordField.getPassword()),
                UserType.CO
            );
            new LoginDialog(window, response);
        };
    }

    private void setButtonActions() {
        signInButton.addActionListener(signIn());
        signUpButton.addActionListener(singUp());
    }
}
