package app.views.components.auth;

import app.controllers.Auth;
import app.controllers.AuthController;
import app.controllers.DialogResponse;
import app.models.Session;
import app.models.users.User;
import app.views.Window;
import app.views.components.dashboard.MainWindow;
import javax.swing.*;
import lombok.Setter;

@Setter
public class LoginForm extends AuthForm {

    private Auth authController;

    public LoginForm(Window window) {
        super("Iniciar sesión", window);
        this.authController = AuthController.getInstance();
        setButtonActions();
    }

    private boolean isInvalidUsername(String username) {
        if (username.equals(this.usernamePlaceholder)) {
            new LoginDialog(
                window,
                "Nombre de usuario inválido",
                JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        return false;
    }

    private void enterSession(Session session) {
        this.window.dispose();
        MainWindow mainWindow = new MainWindow(session);
        mainWindow.setVisible(true);
        if (session.isGuest()) {
            new LoginDialog(mainWindow, "Sesión iniciada como invitado");
        }
    }

    private void enterAsGuest() {
        enterSession(Session.asGuest());
    }

    private void signIn() {
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
    }

    private void setButtonActions() {
        signInButton.onClick(this::signIn);
        enterAsGuestLabel.onClick(this::enterAsGuest);
    }

    @Override
    public void configureLayout() {
        new FormLayout(this);
    }
}
