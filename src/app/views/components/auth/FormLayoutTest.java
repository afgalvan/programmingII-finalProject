package app.views.components.auth;

import app.views.components.atomic.WindowOptionButtons;
import java.awt.*;
import javax.swing.*;

public class FormLayoutTest {

    private final AuthForm form;
    private final WindowOptionButtons windowOptions;
    private final JPanel formContainer;

    public FormLayoutTest(AuthForm form) {
        this.form = form;
        this.windowOptions = new WindowOptionButtons(form.window);
        this.formContainer = new JPanel();
        this.configureLayout();
    }

    public void configureLayout() {
        form.setLayout(new BorderLayout());
        configureContainerLayout();

        form.add(windowOptions, BorderLayout.PAGE_START);
        form.add(formContainer, BorderLayout.CENTER);
    }

    public void configureContainerLayout() {
        this.formContainer.setBackground(Color.WHITE);
        this.formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.PAGE_AXIS));
        this.addComponent(formContainer, form.title);
        this.addComponent(formContainer, form.usernameField);
        this.addComponent(formContainer, form.passwordField);
        this.addComponent(formContainer, form.enterAsGuestLabel);
        this.addComponent(formContainer, form.signInButton);
    }

    public void addComponent(Container container, JComponent component) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(component);
    }
}
