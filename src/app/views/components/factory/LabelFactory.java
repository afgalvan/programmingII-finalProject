package app.views.components.factory;

import app.views.components.atomic.Clickable;
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

    public static JLabel sectionTitle(String title) {
        JLabel label = LabelFactory.createLabel(title, Color.BLACK, Font.BOLD, 22);
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        return label;
    }

    public static Clickable option(String title, Runnable click) {
        Clickable option = option(title);
        option.onClick(click);
        return option;
    }

    public static Clickable option(String title) {
        val option = new Clickable(title);
        option.setFont(new Font("Segeo UI", Font.PLAIN, 20));
        option.setForeground(Color.GRAY);
        option.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        return option;
    }
}
