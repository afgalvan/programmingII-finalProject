package app.views.components.auth;

import app.controllers.DialogResponse;
import app.models.users.User;

import java.awt.*;
import javax.swing.*;

public class LoginDialog extends JOptionPane {

    public LoginDialog(Frame frame, DialogResponse<User> dialogResponse) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);

        showMessageDialog(
            frame,
            dialogResponse.getMessage(),
            dialogResponse.getTitle(),
            dialogResponse.getType()
        );
    }
}
