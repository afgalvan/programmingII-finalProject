package app.views.components;

import app.views.ColorPalette;
import rojerusan.RSMaterialButtonRectangle;

public class ButtonFactory {

    private ButtonFactory() {}

    public static RSMaterialButtonRectangle mainButton(String title) {
        RSMaterialButtonRectangle button = new RSMaterialButtonRectangle();
        button.setBackground(ColorPalette.BLUE);
        button.setText(title);

        return button;
    }
}
