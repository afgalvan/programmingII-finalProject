package app.views.components.auth;

import app.controllers.DialogResponse;
import app.models.users.User;
import app.views.components.atomic.Dialog;
import javax.swing.*;

public class LoginDialog extends Dialog {

    private static final String TITLE = "Inicio de sesión";

    public LoginDialog(JFrame frame, DialogResponse<User> dialogResponse) {
        this(frame, dialogResponse.getMessage(), dialogResponse.getStatusCode());
    }

    public LoginDialog(JFrame frame, String message) {
        this(frame, message, INFORMATION_MESSAGE);
    }

    public LoginDialog(JFrame frame, String message, int dialogType) {
        super(frame, LoginDialog.TITLE, message, dialogType);
    }
}
