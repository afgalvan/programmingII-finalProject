package app.views.login;

import app.controllers.DialogResponse;
import app.controllers.LoginController;
import app.controllers.UserController;
import app.views.ColorPalette;
import app.views.GraphicalInteraction;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import lombok.Setter;
import lombok.val;
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

        setSize(new Dimension(835, 480));
        setLocationRelativeTo(null);
    }

    private void setFormPanel() {
        body.setBackground(Color.WHITE);
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        formTitle.setHorizontalAlignment(SwingConstants.CENTER);
        formTitle.setText("Iniciar Sesión");

        setUpField(usernameField, "Nombre de usuario");
        setUpField(passwordField, "Contraseña");
        userIcon = reactiveFieldIcon("src/app/views/assets/pass.png");
        passwordIcon = reactiveFieldIcon("src/app/views/assets/user.png");

        usernamePadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );
        passwordPadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );

        signInButton = reactiveButton("Iniciar");
        signUpButton = reactiveButton("Registrar");
    }

    private void setLandingPanel() {
        landing.setBackground(ColorPalette.BLUE);
        landing.setLayout(null);

        val councilLogo = new JLabel();
        val councilIcon = new ImageIcon("src/app/views/assets/councilIcon.png")
            .getImage()
            .getScaledInstance(149, 157, Image.SCALE_DEFAULT);
        councilLogo.setIcon(
           new ImageIcon(councilIcon)
        );
        JLabel judicialBranch = landingLabel("Rama Judicial");
        JLabel councilLabel = landingLabel("Consejo Superior de la Judicatura");
        JLabel colombianRepublic = landingLabel("República de Colombia");

        landing.add(councilLogo);

        councilLogo.setBounds(130, 30, 290, 280);
        judicialBranch.setBounds(140, 180, 290, 180);
        councilLabel.setBounds(50, 210, 390, 190);
        colombianRepublic.setBounds(95, 290, 290, 190);
    }

    private JLabel landingLabel(String content) {
        val label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setText(content);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        landing.add(label);
        return label;
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
        fieldIcon.setIcon(new ImageIcon(iconPath));
        fieldIcon.setBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 1, ColorPalette.CREAM)
        );
        fieldIcon.setOpaque(true);

        return fieldIcon;
    }

    private RSMaterialButtonRectangle reactiveButton(String title) {
        RSMaterialButtonRectangle button = new RSMaterialButtonRectangle();
        button.setBackground(ColorPalette.BLUE);
        button.setText(title);

        return button;
    }

    private void setButtonActions() {
        GraphicalInteraction.addFocusListener(
            usernameField,
            () -> {
                if (
                    usernameField.getText().equals("Nombre de usuario")
                ) usernameField.setText("");
                if (
                    String.valueOf(passwordField.getPassword()).equals("Contraseña")
                ) passwordField.setEchoChar((char) 0);
            },
            () -> {
                if (usernameField.getText().equals("")) usernameField.setText(
                    "Nombre de usuario"
                );
                if (
                    String.valueOf(passwordField.getPassword()).equals("Contraseña")
                ) passwordField.setEchoChar((char) 0);
            }
        );

        GraphicalInteraction.addFocusListener(
            passwordField,
            () -> {
                if (
                    String.valueOf(passwordField.getPassword()).equals("Contraseña")
                ) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
            },
            () -> {
                if (String.valueOf(passwordField.getPassword()).equals("")) {
                    passwordField.setText("Contraseña");
                    passwordField.setEchoChar('•');
                }
            }
        );

        signInButton.addActionListener(
            evt -> {
                DialogResponse response = loginController.logUser(
                    usernameField.getText(),
                    String.valueOf(passwordField.getPassword())
                );
                new LoginDialog(this, response);
            }
        );
        signUpButton.addActionListener(
            evt -> {
                DialogResponse response = loginController.registerUser(
                    usernameField.getText(),
                    String.valueOf(passwordField.getPassword())
                );
                new LoginDialog(this, response);
            }
        );
    }
}
