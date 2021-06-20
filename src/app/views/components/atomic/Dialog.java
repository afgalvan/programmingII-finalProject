package app.views.components.atomic;

import java.awt.*;
import javax.swing.*;

public class Dialog extends JOptionPane {

    public Dialog(JFrame frame, String title, String message, int dialogType) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.setButtonMargin", false);

        showMessageDialog(frame, message, title, dialogType);
    }
}
