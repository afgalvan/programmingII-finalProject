package app.views.components.auth;

import app.views.Window;
import java.awt.*;

public class AuthWindow extends Window {

    private final LandingPanel landing;
    private final AuthForm form;

    public AuthWindow() {
        form = new LoginForm(this);
        landing = new LandingPanel();
        setSize(new Dimension(835, 480));
        setLocationRelativeTo(null);
        initComponents();
    }

    public void initComponents() {
        configureLayout();
    }

    private void configureLayout() {
        this.setLayout(new GridLayout(0, 2));
        this.add(landing);
        this.add(form);
    }
}
