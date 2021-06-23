package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.assets.ImageUtils;
import app.views.components.atomic.RoundButtonIcon;
import app.views.components.atomic.WindowOptionButtons;
import app.views.components.factory.ButtonFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;

public class TopBar extends JPanel {

    @Getter
    private final RoundButtonIcon signOutButton;

    private final WindowOptionButtons topGap;
    private final JPanel signOutSide;
    private final JPanel councilSide;
    private final JLabel bottomGap;

    public TopBar() {
        this.councilSide = new JPanel();
        this.signOutSide = new JPanel();
        Icon signOutImage = new ImageIcon(ImageUtils.icon24x24.apply("power.png"));
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

        Icon councilImage = new ImageIcon(ImageUtils.image.apply("council.png"));
        this.councilSide.add(new JLabel(councilImage));
        this.councilSide.setBackground(this.getBackground());
        this.councilSide.setPreferredSize(new Dimension(150, 90));
        this.councilSide.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        this.signOutSide.add(signOutButton);
        this.signOutSide.setBackground(this.getBackground());
        this.signOutSide.setPreferredSize(new Dimension(100, 0));
        this.signOutSide.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));

        this.initGaps();
    }

    public void initGaps() {
        this.bottomGap.setBackground(Color.WHITE);
        this.bottomGap.setPreferredSize(new Dimension(0, 15));
    }

    public void configureLayout() {
        this.setLayout(new BorderLayout());
        this.add(this.topGap, BorderLayout.PAGE_START);
        this.add(this.councilSide, BorderLayout.LINE_START);
        this.add(this.signOutSide, BorderLayout.LINE_END);
        this.add(this.bottomGap, BorderLayout.PAGE_END);
    }
}
