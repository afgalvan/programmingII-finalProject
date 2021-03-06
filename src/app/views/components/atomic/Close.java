package app.views.components.atomic;

import java.awt.*;
import javax.swing.*;

public class Close extends Clickable {

    public Close() {
        this.setText("X");
        this.setFont(new Font("Tahoma", Font.BOLD, 17));
        this.setHorizontalAlignment(SwingConstants.CENTER);

        this.onClick(() -> System.exit(0));
    }
}
