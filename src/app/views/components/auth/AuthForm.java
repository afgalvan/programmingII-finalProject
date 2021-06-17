package app.views.components.auth;

import app.views.ColorPalette;
import app.views.GraphicalInteraction;
import app.views.Window;
import app.views.components.factory.ButtonFactory;
import app.views.components.factory.FieldFactory;
import app.views.components.factory.ImageFactory;

import java.awt.*;
import javax.swing.*;

import rojerusan.RSMaterialButtonRectangle;
import rojerusan.RSPasswordTextPlaceHolder;

public abstract class AuthForm extends JPanel {

    protected Window window;
    protected JLabel title;
    protected JTextField usernameField;
    protected RSPasswordTextPlaceHolder passwordField;
    protected final String usernamePlaceholder = "Nombre de usuario";
    protected final String passwordPlaceholder = "Contraseña";
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

        usernameField = FieldFactory.fieldForm(this.usernamePlaceholder);
        passwordField = FieldFactory.passwordForm(this.passwordPlaceholder);

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
                    usernameField.getText().equals(this.usernamePlaceholder)
                ) usernameField.setText("");
                if (
                    String.valueOf(passwordField.getPassword()).equals(this.passwordPlaceholder)
                ) passwordField.setEchoChar((char) 0);
            },
            () -> {
                if (usernameField.getText().equals("")) usernameField.setText(
                    this.usernamePlaceholder
                );
                if (
                    String.valueOf(passwordField.getPassword()).equals(this.passwordPlaceholder)
                ) passwordField.setEchoChar((char) 0);
            }
        );
    }

    private void setPasswordFieldFocus() {
        GraphicalInteraction.addFocusListener(
            passwordField,
            () -> {
                String password = String.valueOf(passwordField.getPassword());
                if (password.equals(this.passwordPlaceholder)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
            },
            () -> {
                String password = String.valueOf(passwordField.getPassword());
                if (password.equals("")) {
                    passwordField.setText(this.passwordPlaceholder);
                    passwordField.setEchoChar('•');
                }
                if (password.equals(this.passwordPlaceholder)) {
                    passwordField.setEchoChar((char) 0);
                }
            }
        );
    }
}
