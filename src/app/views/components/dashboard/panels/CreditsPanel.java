package app.views.components.dashboard.panels;

import java.awt.*;

public class CreditsPanel extends CenterPanel {

    private static final CreditsPanel instance = new CreditsPanel();

    private CreditsPanel() {
        this.setBackground(Color.PINK);
    }

    public static CreditsPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        // To init
    }
}
