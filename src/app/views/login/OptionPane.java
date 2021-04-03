package app.views.login;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import javax.swing.*;

public class OptionPane extends JOptionPane {

    public OptionPane(Frame frame, String response, String title, int optionPane) {
        FlatLightLaf.install();
        showConfirmDialog(frame, response, title, optionPane);
    }
}
