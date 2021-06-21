package app.views.components.dashboard;

import java.awt.*;

public class AdminPanel extends DashboardSection {

    private static final AdminPanel instance = new AdminPanel();

    private AdminPanel() {
        this.setBackground(Color.GREEN);
    }

    public static AdminPanel getInstance() {
        return instance;
    }
}
