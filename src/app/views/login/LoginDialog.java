package app.views.login;

import app.models.DialogResponse;
import java.awt.*;
import javax.swing.*;

public class LoginDialog extends JOptionPane {

    public LoginDialog(Frame frame, DialogResponse dialogResponse) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);

        showConfirmDialog(
            frame,
            dialogResponse.getContent(),
            dialogResponse.getTitle(),
            dialogResponse.getOption()
        );
    }
}
