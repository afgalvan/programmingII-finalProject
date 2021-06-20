package app.views.components.atomic;

import app.views.Window;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class Minimize extends Clickable {

    public Minimize(Window window) {
        this.setText("-");
        this.setFont(new Font("Tahoma", Font.BOLD, 30));
        this.setHorizontalAlignment(SwingConstants.CENTER);

        this.onClick(() -> window.setState(JFrame.ICONIFIED));
    }
}
