package app.views.components.atomic;

import rojerusan.RSMaterialButtonRectangle;

public class RectangleButton extends RSMaterialButtonRectangle implements OnClick {

    @Override
    public void onClick(Runnable runnable) {
        this.addActionListener(actionEvent -> runnable.run());
    }
}
