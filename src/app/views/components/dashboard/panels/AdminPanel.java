package app.views.components.dashboard.panels;

import java.awt.*;

public class AdminPanel extends CenterPanel {

    private static final AdminPanel instance = new AdminPanel();

    private AdminPanel() {
        this.setBackground(Color.GREEN);
    }

    public static AdminPanel getInstance() {
        return instance;
    }
}
