package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;

public class MenuBar extends JPanel {

    public MenuBar() {
        this.configureLayout();
        this.initComponents();
    }

    public void initComponents() {
        this.setBackground(ColorPalette.BLUE);
        this.setPreferredSize(new Dimension(300, 0));
        JLabel menuTitle = sectionTitle("Menu");
        JLabel othersTitle = sectionTitle("Otros");
        this.add(menuTitle);
        this.add(othersTitle);
    }

    public void configureLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public JLabel sectionTitle(String title) {
        JLabel label = LabelFactory.createLabel(title, ColorPalette.CLAY, Font.BOLD, 22);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        return label;
    }
}
