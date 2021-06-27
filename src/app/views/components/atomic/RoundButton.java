package app.views.components.atomic;

import rojerusan.RSMaterialButtonCircle;

public class RoundButton extends RSMaterialButtonCircle implements OnClick {

    public RoundButton(String text) {
        this.setText(text);
        this.setToolTipText(text);
    }

    @Override
    public void onClick(Runnable runnable) {
        this.addActionListener(actionEvent -> runnable.run());
    }
}
