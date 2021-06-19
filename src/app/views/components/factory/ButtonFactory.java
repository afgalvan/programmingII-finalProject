package app.views.components.factory;

import app.views.ColorPalette;
import rojerusan.RSMaterialButtonRectangle;

public final class ButtonFactory {

    private ButtonFactory() {}

    public static RSMaterialButtonRectangle createMainButton(String title) {
        RSMaterialButtonRectangle button = new RSMaterialButtonRectangle();
        button.setBackground(ColorPalette.BLUE);
        button.setText(title);

        return button;
    }
}
