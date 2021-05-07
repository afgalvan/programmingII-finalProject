package app.views;

import app.views.auth.LoginView;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends Window implements ActionListener {

    public View() {
        FlatDarkLaf.install();
        initComponents();
    }

    public void initComponents() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        new LoginView().setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {}
}
