package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.Window;
import app.views.components.atomic.RoundButton;
import app.views.components.atomic.WindowOptionButtons;
import app.views.components.factory.ButtonFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;

public class TopBar extends JPanel {

    private JPanel signOutSide;

    @Getter
    private RoundButton signOutButton;

    private final Window window;
    private JLabel councilPanel;
    private WindowOptionButtons topGap;
    private JLabel bottomGap;

    public TopBar(Window window) {
        this.window = window;
        this.initComponents();
        this.configureLayout();
        this.addInteraction();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.CREAM));
        this.setPreferredSize(new Dimension(0, 90));

        Icon councilImage = new ImageIcon("src/app/views/assets/council.jpg");
        this.councilPanel = new JLabel();
        this.councilPanel.setIcon(councilImage);

        Icon signOutImage = new ImageIcon("src/app/views/assets/icons/24x24/power.png");
        this.signOutButton = ButtonFactory.createRoundButtonOfImage(signOutImage);
        this.signOutSide = new JPanel();
        this.signOutSide.setBackground(Color.WHITE);
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
        this.signOutSide.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
        this.add(this.topGap, BorderLayout.PAGE_START);
        this.add(this.councilPanel, BorderLayout.LINE_START);
        this.add(this.signOutSide, BorderLayout.LINE_END);
        this.add(this.bottomGap, BorderLayout.PAGE_END);
    }

    public void addInteraction() {
        // this.signOutButton.onClick(this::signOut);
    }

    private void signOut() {}
}
