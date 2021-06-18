package app.views.components.dashboard;

import app.views.ColorPalette;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JPanel {
    public MenuBar() {
        this.setBackground(ColorPalette.BLUE);
        this.setPreferredSize(new Dimension(300, 0));
    }
}
