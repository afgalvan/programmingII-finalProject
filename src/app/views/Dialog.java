package app.views;

import java.awt.*;
import javax.swing.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Dialog extends JDialog {

    public Dialog(JFrame frame, boolean modal) {
        super(frame, modal);
        Image icon = new ImageIcon("src/app/views/assets/UPC.png").getImage();
        setIconImage(icon);
    }
}
