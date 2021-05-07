package app.views.auth;

import app.controllers.DialogResponse;
import app.controllers.LoginController;
import app.controllers.UserController;
import app.views.Window;
import lombok.Setter;

@Setter
public class LoginForm extends AuthForm {

    private LoginController loginController;
    private UserController userController;

    public LoginForm(Window window) {
        super("Inciar sesión", window);
        this.loginController = new LoginController();
        this.userController = new UserController();
        setButtonActions();
    }

    private void setButtonActions() {
        signInButton.addActionListener(
            evt -> {
                DialogResponse response = loginController.logUser(
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
                    String.valueOf(passwordField.getPassword())
                );
                new LoginDialog(window, response);
            }
        );
    }
}
