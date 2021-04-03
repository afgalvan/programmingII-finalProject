package app.views.login;

import app.controllers.LoginController;
import app.controllers.UserController;
import app.views.ColorPalette;
import app.views.InterfaceInteraction;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import lombok.Setter;
import rojerusan.RSMaterialButtonRectangle;

@Setter
public class LoginView extends LoginLayout {

    private LoginController loginController;
    private UserController userController;

    public LoginView() {
        loginController = new LoginController();
        userController = new UserController();
        initComponents();
    }

    private void initComponents() {
        setFormPanel();
        setLandingPanel();
        setButtonActions();
        layoutConfiguration();

        setSize(new Dimension(837, 480));
        setLocationRelativeTo(null);
    }

    private void setFormPanel() {
        body.setBackground(Color.WHITE);
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        formTitle.setHorizontalAlignment(SwingConstants.CENTER);
        formTitle.setText("Sesiones");

        setUpField(usernameField, "Nombre de usuario");
        setUpField(passwordField, "Contraseña");
        userIcon = reactiveFieldIcon("/app/views/assets/pass.png");
        passwordIcon = reactiveFieldIcon("/app/views/assets/user.png");

        usernamePadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );
        passwordPadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );

        signInButton = reactiveButton("Iniciar");
        signUpButton = reactiveButton("Registrarse");
    }

    private void setLandingPanel() {
        landing.setBackground(ColorPalette.GREEN);
        landing.setLayout(null);

        JLabel councilLogo = new JLabel();
        councilLogo.setIcon(
            new ImageIcon(getClass().getResource("/app/views/assets/council.jpg"))
        );
        JLabel upcLogo = new JLabel();
        upcLogo.setIcon(
            new ImageIcon(getClass().getResource("/app/views/assets/UPC.png"))
        );
        landing.add(upcLogo);
        upcLogo.setBounds(85, -30, 550, 550);
    }

    private void setUpField(JTextComponent field, String placeHolder) {
        field.setText(placeHolder);
        field.setToolTipText(placeHolder);
        field.setBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 0, ColorPalette.CREAM)
        );
        field.setForeground(ColorPalette.CREAM);
        field.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }

    private JLabel reactiveFieldIcon(String iconPath) {
        JLabel fieldIcon = new JLabel();

        fieldIcon.setBackground(Color.WHITE);
        fieldIcon.setHorizontalAlignment(SwingConstants.CENTER);
        fieldIcon.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        fieldIcon.setBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 1, ColorPalette.CREAM)
        );
        fieldIcon.setOpaque(true);

        return fieldIcon;
    }

    private RSMaterialButtonRectangle reactiveButton(String title) {
        RSMaterialButtonRectangle button = new RSMaterialButtonRectangle();
        button.setBackground(ColorPalette.GREEN);
        button.setText(title);

        return button;
    }

    private void setButtonActions() {
        InterfaceInteraction.addFocusListener(
            usernameField,
            () -> {
                if (
                    usernameField.getText().equals("Nombre de usuario")
                ) usernameField.setText("");
                if (
                    passwordField.getText().equals("Contraseña")
                ) passwordField.setEchoChar((char) 0);
            },
            () -> {
                if (usernameField.getText().equals("")) usernameField.setText(
                    "Nombre de usuario"
                );
                if (
                    passwordField.getText().equals("Contraseña")
                ) passwordField.setEchoChar((char) 0);
            }
        );

        InterfaceInteraction.addFocusListener(
            passwordField,
            () -> {
                if (passwordField.getText().equals("Contraseña")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
            },
            () -> {
                if (passwordField.getText().equals("")) {
                    passwordField.setText("Contraseña");
                    passwordField.setEchoChar('•');
                }
            }
        );

        signInButton.addActionListener(
            evt -> {
                String response = loginController.logUser(
                    usernameField.getText(),
                    passwordField.getText()
                );
                JDialog responseDialog = new LoginDialog(this, response, true);
                responseDialog.setVisible(true);
            }
        );
        signUpButton.addActionListener(
            evt -> {
                String response = loginController.logUser(
                    usernameField.getText(),
                    passwordField.getText()
                );
            }
        );
    }
}
