package app.views.components.factory;

import java.awt.*;
import javax.swing.*;
import lombok.val;

public final class LabelFactory {

    private LabelFactory() {}

    public static JLabel createDefaultLabel(String content) {
        return createLabel(content, Color.WHITE);
    }

    public static JLabel createLabel(String content, Color color) {
        return createLabel(content, color, Font.PLAIN);
    }

    public static JLabel createLabel(String content, Color color, int fontStyle) {
        return createLabel(content, color, fontStyle, 20);
    }

    public static JLabel createLabel(
        String content,
        Color color,
        int fontStyle,
        int fontSize
    ) {
        val label = new JLabel();
        label.setForeground(color);
        label.setText(content);
        label.setFont(new Font("Segoe UI", fontStyle, fontSize));
        return label;
    }
}
