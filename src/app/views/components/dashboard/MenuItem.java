package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.GraphicalInteraction;
import app.views.components.atomic.OnClick;
import app.views.components.atomic.RectangleButton;
import app.views.components.dashboard.panels.CenterPanel;
import app.views.components.factory.ButtonFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;

@Getter
public class MenuItem extends JPanel implements OnClick {

    private final Icon icon;
    private Runnable runnable;
    private final RectangleButton pressItem;
    private final CenterPanel section;

    public MenuItem(Icon icon, String title, CenterPanel section) {
        this.icon = icon;
        this.pressItem = ButtonFactory.createMainButton(title);
        this.section = section;
        this.initComponents();
    }

    public void initComponents() {
        this.configureColor();
        this.pressItem.setPreferredSize(new Dimension(5, 5));

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setBackground(ColorPalette.BLUE);
        this.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

        JLabel label = new JLabel(icon);
        this.add(label, BorderLayout.LINE_START);
        this.add(pressItem, BorderLayout.CENTER);
    }

    public void configureColor() {
        if (this.section.isVisible()) {
            this.pressItem.setForeground(ColorPalette.CLAY_20);
            this.pressItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } else {
            this.pressItem.setForeground(ColorPalette.CLAY);
            this.pressItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        this.pressItem.setCursor(this.getCursor());
    }

    @Override
    public void onClick(Runnable runnable) {
        this.runnable = runnable;
        GraphicalInteraction.addMouseListener(this, runnable);
    }
}
