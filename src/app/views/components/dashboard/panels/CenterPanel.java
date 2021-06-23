package app.views.components.dashboard.panels;

import app.views.ColorPalette;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CenterPanel extends JPanel {

    private boolean isVisible;

    public CenterPanel() {
        this.setBackground(ColorPalette.PINK);
        this.isVisible = false;
    }

    public abstract void initComponents();

    public static void recreate() {
        recreate(AboutPanel.getInstance());
        recreate(AdminPanel.getInstance());
        recreate(CreditsPanel.getInstance());
        recreate(DocumentsPanel.getInstance());
        recreate(HomePanel.getInstance());
        recreate(SearchPanel.getInstance());
        recreate(SettingsPanel.getInstance());
    }

    private static void recreate(CenterPanel panel) {
        panel.removeAll();
        panel.initComponents();
        panel.validate();
        panel.repaint();
    }
}
