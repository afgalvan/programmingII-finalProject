package app.views.components.atomic;

import app.views.GraphicalInteraction;
import java.awt.*;
import javax.swing.*;

public class Clickable extends JLabel implements OnClick {

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

    @Override
    public void onClick(Runnable runnable) {
        GraphicalInteraction.addMouseListener(this, runnable);
    }
}
