package app.views;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GraphicalInteraction {

    public static void addMouseListener(JComponent component, Runnable action) {
        component.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    action.run();
                }
            }
        );
    }

    public static void addHover(JComponent component, Runnable action) {
        component.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    action.run();
                }
            }
        );
    }

    public static void addFocusListener(
        JComponent component,
        Runnable focusOn,
        Runnable focusOff
    ) {
        component.addFocusListener(
            new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    focusOn.run();
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    focusOff.run();
                }
            }
        );
    }
}
