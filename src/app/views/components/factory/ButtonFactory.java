package app.views.components.factory;

import app.views.ColorPalette;
import app.views.components.atomic.RectangleButton;
import app.views.components.atomic.RoundButton;
import java.awt.*;
import javax.swing.*;

public final class ButtonFactory {

    private ButtonFactory() {}

    public static RectangleButton createMainButton(String title) {
        RectangleButton button = new RectangleButton();
        button.setBackground(ColorPalette.BLUE);
        button.setText(title);

        return button;
    }

    public static RoundButton createRoundButtonOfImage(Icon icon) {
        RoundButton button = new RoundButton(icon);
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(50, 50));

        return button;
    }
}
