package app.views.auth;

import app.views.ColorPalette;
import app.views.components.ImageFactory;
import java.awt.*;
import javax.swing.*;
import lombok.val;

public class LandingPanel extends JPanel {

    private JLabel judicialBranch;
    private JLabel councilLabel;
    private JLabel colombianRepublic;
    private JLabel councilLogo;

    public LandingPanel() {
        initComponents();
        configureLayout();
    }

    public void initComponents() {
        this.setBackground(ColorPalette.BLUE);

        ImageIcon councilIcon = ImageFactory.iconSized(
            "src/app/views/assets/councilIcon.png",
            149,
            157
        );

        this.councilLogo = new JLabel();
        this.councilLogo.setIcon(councilIcon);
        this.add(councilLogo);

        this.judicialBranch = buildLandingLabel("Rama Judicial");
        this.councilLabel = buildLandingLabel("Consejo Superior de la Judicatura");
        this.colombianRepublic = buildLandingLabel("República de Colombia");
    }

    public void configureLayout() {
        this.setLayout(null);

        councilLogo.setBounds(130, 30, 290, 280);
        judicialBranch.setBounds(140, 180, 290, 180);
        councilLabel.setBounds(50, 210, 390, 190);
        colombianRepublic.setBounds(95, 290, 290, 190);
    }

    private JLabel buildLandingLabel(String content) {
        val label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setText(content);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(label);
        return label;
    }
}
