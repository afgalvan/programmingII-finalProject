package app.views.components.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.models.Session;
import app.models.users.User;
import app.views.GraphicalInteraction;
import app.views.Window;
import app.views.components.dashboard.MainWindow;
import java.awt.event.ActionListener;
import javax.swing.*;
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
                "Iniciar sesión",
                "Nombre de usuario inválido",
                JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        return false;
    }

    private void enterSession(Session session) {
        this.window.setVisible(false);
        MainWindow mainWindow = new MainWindow(session);
        mainWindow.setVisible(true);
    }

    private void enterAsGuest() {
        enterSession(new Session());
        new LoginDialog(this.window, "Inicio de sesión", "Sesión iniciada como invitado");
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

            if (!response.isError() && response.getData() != null) {
                enterSession(new Session(response.getData()));
            }
        };
    }

    private void setButtonActions() {
        signInButton.addActionListener(signIn());
        GraphicalInteraction.addMouseListener(enterAsGuestLabel, this::enterAsGuest);
    }

    @Override
    public void configureLayout() {
        new FormLayout(this);
    }
}
