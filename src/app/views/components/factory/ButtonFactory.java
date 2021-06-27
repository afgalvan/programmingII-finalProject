package app.views.components.factory;

import app.views.ColorPalette;
import app.views.components.atomic.RectangleButton;
import app.views.components.atomic.RoundButton;
import app.views.components.atomic.RoundButtonIcon;
import java.awt.*;
import javax.swing.*;

public final class ButtonFactory {

    private ButtonFactory() {}

    public static RectangleButton createMainButton(String title) {
        RectangleButton button = new RectangleButton(title);
        button.setBackground(ColorPalette.BLUE);

        return button;
    }

    public static RoundButtonIcon createRoundButtonOfImage(Icon icon) {
        RoundButtonIcon button = new RoundButtonIcon(icon);
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(50, 50));

        return button;
    }

    public static RoundButton createSecondaryRoundButton(String title) {
        RoundButton button = new RoundButton(title);
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(50, 50));

        return button;
    }
}
