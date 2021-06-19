package app.views.components.dashboard;

import app.views.ColorPalette;
import javax.swing.*;

public abstract class DashboardSection extends JPanel {

    public DashboardSection() {
        this.setBackground(ColorPalette.PINK);
    }

    public void configureLayout() {}
}
