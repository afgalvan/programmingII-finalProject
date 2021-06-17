package app.views.auth;

import app.views.ColorPalette;
import app.views.GraphicalInteraction;
import app.views.Window;
import app.views.components.ButtonFactory;
import app.views.components.FieldFactory;
import app.views.components.ImageFactory;
import java.awt.*;
import javax.swing.*;
import rojerusan.RSMaterialButtonRectangle;
import rojerusan.RSPasswordTextPlaceHolder;

public class AuthForm extends JPanel {

    protected Window window;
    protected JLabel title;
    protected JTextField usernameField;
    protected RSPasswordTextPlaceHolder passwordField;
    protected JLabel userIcon;
    protected JLabel passwordIcon;
    protected JLabel usernamePadding;
    protected JLabel passwordPadding;
    protected RSMaterialButtonRectangle signInButton;
    protected RSMaterialButtonRectangle signUpButton;

    public AuthForm(String title, Window window) {
        this.window = window;
        this.title = new JLabel(title);
        this.usernameField = new JTextField();
        this.passwordField = new RSPasswordTextPlaceHolder();
        this.userIcon = new JLabel();
        this.passwordIcon = new JLabel();
        this.usernamePadding = new JLabel();
        this.passwordPadding = new JLabel();
        this.signInButton = new RSMaterialButtonRectangle();
        this.signUpButton = new RSMaterialButtonRectangle();
        initComponents();
    }

    public void initComponents() {
        setFormPanel();
        setFieldActions();
        configureLayout();
    }

    private void setFormPanel() {
        this.setBackground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        usernameField = FieldFactory.fieldForm("Nombre de usuario");
        passwordField = FieldFactory.passwordForm("Contraseña");

        userIcon = ImageFactory.fieldIcon("src/app/views/assets/pass.png");
        passwordIcon = ImageFactory.fieldIcon("src/app/views/assets/user.png");

        usernamePadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );
        passwordPadding.setBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 0, ColorPalette.CREAM)
        );

        signInButton = ButtonFactory.mainButton("Iniciar");
        signUpButton = ButtonFactory.mainButton("Registrar");
    }

    private void configureLayout() {
        new FormLayout(this);
    }

    private void setFieldActions() {
        setUsernameFieldFocus();
        setPasswordFieldFocus();
    }

    private void setUsernameFieldFocus() {
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
    }

    private void setPasswordFieldFocus() {
        GraphicalInteraction.addFocusListener(
            passwordField,
            () -> {
                if (String.valueOf(passwordField.getPassword()).equals("Contraseña")) {
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
    }
}
