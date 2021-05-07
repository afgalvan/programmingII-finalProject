package app.views;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import javax.swing.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Window extends JFrame {

    private final JLabel minimize = new JLabel();
    private final JLabel close = new JLabel();

    public Window() {
        super("Digitalización de procesos.");
        FlatLightLaf.install();
        configureIcon();
        configureButtons();
    }

    private void configureIcon() {
        Image icon = new ImageIcon("src/app/views/assets/councilIcon.png")
            .getImage();
        setIconImage(icon);
    }

    private void configureButtons() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        minimize.setText("-");
        minimize.setFont(new Font("Tahoma", Font.BOLD, 30));
        minimize.setHorizontalAlignment(SwingConstants.CENTER);
        minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));

        close.setText("X");
        close.setFont(new Font("Tahoma", Font.BOLD, 17));
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        windowButtonActions();
    }

    private void windowButtonActions() {
        // prettier-ignore-start
        GraphicalInteraction.addMouseListener(
            minimize, () -> setState(JFrame.ICONIFIED)
        );
        // prettier-ignore-end
        GraphicalInteraction.addMouseListener(close, () -> System.exit(0));
    }
}
