package app.views.components.factory;

import app.views.ColorPalette;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import lombok.val;
import rojerusan.RSMetroTextPlaceHolder;
import rojerusan.RSPasswordTextPlaceHolder;

public final class FieldFactory {

    private FieldFactory() {}

    public static RSMetroTextPlaceHolder createDefaultField(String placeholder) {
        val field = new RSMetroTextPlaceHolder();

        field.setxDarkIcon(true);
        field.setBorderColor(ColorPalette.CREAM);
        field.setForeground(Color.GRAY);
        field.setPlaceholder(placeholder);

        return field;
    }

    public static JPanel createLabeledField(String label, String placeholder) {
        // val container = new JPanel(new GridLayout(2, 0));
        val container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setBackground(ColorPalette.PINK);
        JLabel fieldLabel = LabelFactory.createLabel(
            label,
            ColorPalette.BLUE,
            Font.PLAIN,
            18
        );
        RSMetroTextPlaceHolder field = createDefaultField(placeholder);
        field.setToolTipText(placeholder);

        container.add(fieldLabel);
        container.add(field);

        return container;
    }

    public static JTextField createFieldForm(String placeHolder) {
        val field = new JTextField();
        setupField(field, placeHolder);

        return field;
    }

    public static RSPasswordTextPlaceHolder createPasswordField(String placeHolder) {
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
