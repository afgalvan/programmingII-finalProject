package app.views.components.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.models.users.User;
import app.models.users.UserType;
import app.views.Window;
import app.views.components.dashboard.MainWindow;
import java.awt.event.ActionListener;
import lombok.Setter;

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
            new LoginDialog(
                window,
                new DialogResponse<>("Iniciar sesión", "Nombre de usuario inválido")
            );
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

            if (!response.isError()) {
                this.window.setVisible(false);
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        };
    }

    private void setButtonActions() {
        signInButton.addActionListener(signIn());
    }
}
