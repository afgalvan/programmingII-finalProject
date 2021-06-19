package app.views.components.atomic;

import app.views.GraphicalInteraction;
import java.awt.*;
import javax.swing.*;

public class Close extends Clickable {

    public Close() {
        this.setText("X");
        this.setFont(new Font("Tahoma", Font.BOLD, 17));
        this.setHorizontalAlignment(SwingConstants.CENTER);

        GraphicalInteraction.addMouseListener(this, () -> System.exit(0));
    }
}
