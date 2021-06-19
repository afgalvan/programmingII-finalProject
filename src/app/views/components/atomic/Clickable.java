package app.views.components.atomic;

import java.awt.*;
import javax.swing.*;

public class Clickable extends JLabel {

    public Clickable() {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public Clickable(ImageIcon icon) {
        this();
        this.setIcon(icon);
    }

    public Clickable(String content) {
        this();
        this.setText(content);
    }
}
