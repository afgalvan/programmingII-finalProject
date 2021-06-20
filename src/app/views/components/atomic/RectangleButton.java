package app.views.components.atomic;

import lombok.NoArgsConstructor;
import rojerusan.RSMaterialButtonRectangle;

@NoArgsConstructor
public class RectangleButton extends RSMaterialButtonRectangle implements OnClick {

    public RectangleButton(String title) {
        this.setText(title);
    }

    @Override
    public void onClick(Runnable runnable) {
        this.addActionListener(actionEvent -> runnable.run());
    }
}
