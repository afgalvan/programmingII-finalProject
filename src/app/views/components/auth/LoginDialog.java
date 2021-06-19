package app.views.components.auth;

import app.controllers.DialogResponse;
import app.models.users.User;
import java.awt.*;
import javax.swing.*;

public class LoginDialog extends JOptionPane {

    public LoginDialog(Frame frame, DialogResponse<User> dialogResponse) {
        this(
            frame,
            dialogResponse.getTitle(),
            dialogResponse.getMessage(),
            dialogResponse.getStatusCode()
        );
    }

    public LoginDialog(Frame frame, String title, String message) {
        this(frame, title, message, INFORMATION_MESSAGE);
    }

    public LoginDialog(Frame frame, String title, String message, int dialogType) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);

        showMessageDialog(frame, message, title, dialogType);
    }
}
