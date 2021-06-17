package app.views.auth;

import app.controllers.DialogResponse;
import java.awt.*;
import javax.swing.*;

public class LoginDialog extends JOptionPane {

    public LoginDialog(Frame frame, DialogResponse dialogResponse) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);

        showMessageDialog(
            frame,
            dialogResponse.getData(),
            dialogResponse.getTitle(),
            dialogResponse.getType()
        );
    }
}
