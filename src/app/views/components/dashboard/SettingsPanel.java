package app.views.components.dashboard;

import java.awt.*;

public class SettingsPanel extends DashboardSection {

    private static final SettingsPanel instance = new SettingsPanel();

    private SettingsPanel() {
        this.setBackground(Color.YELLOW);
    }

    public static SettingsPanel getInstance() {
        return instance;
    }
}
