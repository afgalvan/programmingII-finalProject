package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.Window;
import app.views.components.atomic.Clickable;
import app.views.components.atomic.Close;
import app.views.components.atomic.Minimize;
import app.views.components.atomic.WindowOptionButtons;
import java.awt.*;
import javax.swing.*;
import rojerusan.RSPanelImage;

public class TopBar extends JPanel {

    private JLabel signOutSide;
    private final Window window;
    private RSPanelImage councilPanel;
    private WindowOptionButtons topGap;
    private JLabel bottomGap;

    public TopBar(Window window) {
        this.window = window;
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.CREAM));
        this.setPreferredSize(new Dimension(0, 70));
        this.initComponents();
        this.configureLayout();
    }

    public void initComponents() {
        ImageIcon councilImage = new ImageIcon("src/app/views/assets/council.jpg");
        this.councilPanel = new RSPanelImage();
        this.councilPanel.setImagen(councilImage);

        ImageIcon signOutImage = new ImageIcon(
            "src/app/views/assets/icons/24x24/power.png"
        );
        Clickable signOutButton = new Clickable(signOutImage);
        this.signOutSide = new JLabel();
        this.signOutSide.setLayout(new GridLayout(0, 2));
        this.signOutSide.add(signOutButton);
        this.initGaps();
    }

    public void initGaps() {
        this.topGap = new WindowOptionButtons(this.window);

        this.bottomGap = new JLabel();
        this.bottomGap.setBackground(Color.WHITE);
        this.bottomGap.setPreferredSize(new Dimension(0, 15));
    }

    public void configureLayout() {
        this.setLayout(new BorderLayout());
        this.councilPanel.setPreferredSize(new Dimension(90, 60));
        this.signOutSide.setPreferredSize(new Dimension(100, 0));
        this.signOutSide.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        this.add(this.topGap, BorderLayout.PAGE_START);
        this.add(this.councilPanel, BorderLayout.LINE_START);
        this.add(this.signOutSide, BorderLayout.LINE_END);
        this.add(this.bottomGap, BorderLayout.PAGE_END);
    }
}
