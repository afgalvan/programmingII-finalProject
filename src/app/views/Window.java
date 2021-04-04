package app.views;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import javax.swing.*;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class Window extends JFrame {

    private final JLabel minimize = new JLabel();
    private final JLabel close = new JLabel();

    public Window() {
        FlatLightLaf.install();
        Image icon = new ImageIcon("src/app/views/assets/UPC.png").getImage();
        setIconImage(icon);
        windowConfiguration();
    }

    public JLabel getClose() {
        return close;
    }

    public JLabel getMinimize() {
        return minimize;
    }

    private void windowConfiguration() {
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