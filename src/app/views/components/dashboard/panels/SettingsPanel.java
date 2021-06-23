package app.views.components.dashboard.panels;

import java.awt.*;

public class SettingsPanel extends CenterPanel {

    private static final SettingsPanel instance = new SettingsPanel();

    private SettingsPanel() {
        this.setBackground(Color.YELLOW);
    }

    public static SettingsPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        // To init
    }
}
