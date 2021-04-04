package app.views.login;

import java.awt.*;
import javax.swing.*;

public class OptionPane extends JOptionPane {

    public OptionPane(Frame frame, String response, String title, int optionPane) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);
        showConfirmDialog(frame, response, title, optionPane);
    }
}
