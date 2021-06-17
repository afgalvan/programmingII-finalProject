package app.views.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.controllers.UserController;
import app.models.users.UserType;
import app.views.Window;
import lombok.Setter;

@Setter
public class LoginForm extends AuthForm {

    private Auth loginController;
    private UserController userController;

    public LoginForm(Window window) {
        super("Inciar sesión", window);
        this.loginController = AuthController.getInstance();
        this.userController = UserController.getInstance();
        setButtonActions();
    }

    private void setButtonActions() {
        signInButton.addActionListener(
            evt -> {
                DialogResponse response = loginController.loginUser(
                    usernameField.getText(),
                    String.valueOf(passwordField.getPassword())
                );
                new LoginDialog(window, response);
            }
        );
        signUpButton.addActionListener(
            evt -> {
                DialogResponse response = loginController.registerUser(
                    usernameField.getText(),
                    String.valueOf(passwordField.getPassword()),
                    UserType.CO
                );
                new LoginDialog(window, response);
            }
        );
    }
}
