package app.views;

import app.views.components.atomic.Close;
import app.views.components.atomic.Minimize;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import javax.swing.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Window extends JFrame {

    private Minimize minimize;
    private Close close;

    public Window() {
        super("Digitalización de procesos.");
        FlatLightLaf.install();
        configureIcon();
        configureButtons();
    }

    private void configureIcon() {
        Image icon = new ImageIcon("src/app/views/assets/councilIcon.png").getImage();
        setIconImage(icon);
    }

    private void configureButtons() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        this.minimize = new Minimize(this);
        this.close = new Close();
    }
}
