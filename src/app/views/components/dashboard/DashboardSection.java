package app.views.components.dashboard;

import app.views.ColorPalette;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DashboardSection extends JPanel {

    private boolean isVisible;

    public DashboardSection() {
        this.setBackground(ColorPalette.PINK);
        this.isVisible = false;
    }
}
