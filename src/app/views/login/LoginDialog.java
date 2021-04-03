package app.views.login;

import app.views.Dialog;
import java.awt.*;
import javax.swing.*;

public class LoginDialog extends Dialog {

    private final JFrame frame;
    private Container container;
    private final String message;

    public LoginDialog(JFrame frame, String message, boolean modal) {
        super(frame, modal);
        this.message = message;
        this.frame = frame;
        initComponents();
    }

    public void initComponents() {
        container = getContentPane();
        setUndecorated(true);

        setSize(300, 150);
        setLocationRelativeTo(frame);
        layoutConfiguration();

        JLabel label = new JLabel();
        label.setForeground(Color.BLACK);
        label.setText(message);
        Panel main = new Panel(new FlowLayout());
        main.add(label);
        container.add(main);
    }

    public void layoutConfiguration() {}
}
