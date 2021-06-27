package app.views.components.atomic;

import app.views.Window;
import java.awt.*;
import javax.swing.*;

public class WindowOptionButtons extends JLabel {

    public WindowOptionButtons(Window window) {
        this.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(0, 20));
        this.add(Box.createHorizontalGlue());
        this.add(new Minimize(window));
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(new Close());
        this.add(Box.createRigidArea(new Dimension(10, 0)));
    }
}
