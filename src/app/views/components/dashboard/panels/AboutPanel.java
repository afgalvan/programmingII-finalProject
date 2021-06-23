package app.views.components.dashboard.panels;

import java.awt.*;

public class AboutPanel extends CenterPanel {

    private static final AboutPanel instance = new AboutPanel();

    private AboutPanel() {
        this.setBackground(Color.GRAY);
    }

    public static AboutPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        // To init
    }
}
