package app.views.components.atomic;

import javax.swing.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoundButtonIcon extends MaterialButtonCircle implements OnClick {

    public RoundButtonIcon(Icon icon) {
        this.setIcon(icon);
    }

    @Override
    public void onClick(Runnable runnable) {
        this.addActionListener(actionEvent -> runnable.run());
    }
}
