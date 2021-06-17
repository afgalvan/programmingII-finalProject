package app.views.components.factory;

import app.views.ColorPalette;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import lombok.val;
import rojerusan.RSPasswordTextPlaceHolder;

public class FieldFactory {

    private FieldFactory() {}

    public static JTextField fieldForm(String placeHolder) {
        val field = new JTextField();
        setupField(field, placeHolder);

        return field;
    }

    public static RSPasswordTextPlaceHolder passwordForm(String placeHolder) {
        val passwordField = new RSPasswordTextPlaceHolder();
        setupField(passwordField, placeHolder);
        return passwordField;
    }

    private static void setupField(JTextComponent component, String placeHolder) {
        component.setText(placeHolder);
        component.setToolTipText(placeHolder);
        component.setBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 1, ColorPalette.CREAM)
        );
        component.setForeground(ColorPalette.CREAM);
        component.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
}
