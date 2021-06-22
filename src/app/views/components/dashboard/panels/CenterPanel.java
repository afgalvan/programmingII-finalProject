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
}
