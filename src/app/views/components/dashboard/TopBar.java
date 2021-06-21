package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.assets.IconUtils;
import app.views.components.atomic.RoundButtonIcon;
import app.views.components.atomic.WindowOptionButtons;
import app.views.components.factory.ButtonFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;

public class TopBar extends JPanel {

    @Getter
    private final RoundButtonIcon signOutButton;

    private final JPanel signOutSide;
    private final JLabel councilPanel;
    private final WindowOptionButtons topGap;
    private final JLabel bottomGap;

    public TopBar() {
        this.councilPanel = new JLabel();
        this.signOutSide = new JPanel();
        Icon signOutImage = new ImageIcon(IconUtils.icon24x24.apply("power.png"));
        this.signOutButton = ButtonFactory.createRoundButtonOfImage(signOutImage);

        this.topGap = new WindowOptionButtons(MainWindow.state);
        this.bottomGap = new JLabel();
        this.initComponents();
        this.configureLayout();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.CREAM));
        this.setPreferredSize(new Dimension(0, 90));

        Icon councilImage = new ImageIcon(IconUtils.image.apply("council.jpg"));
        this.councilPanel.setIcon(councilImage);

        this.signOutSide.setBackground(Color.WHITE);
        this.signOutSide.add(signOutButton);
        this.initGaps();
    }

    public void initGaps() {
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
}
