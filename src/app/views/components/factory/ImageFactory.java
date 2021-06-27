package app.views.components.factory;

import app.views.ColorPalette;
import java.awt.*;
import javax.swing.*;

public final class ImageFactory {

    private ImageFactory() {}

    public static ImageIcon createIconSized(String src, int width, int height) {
        Image originalImage = new ImageIcon(src).getImage();
        Image resizedImage = originalImage.getScaledInstance(
            width,
            height,
            Image.SCALE_DEFAULT
        );

        return new ImageIcon(resizedImage);
    }

    public static JLabel createFieldIcon(String iconPath) {
        JLabel fieldIcon = new JLabel();

        fieldIcon.setBackground(Color.WHITE);
        fieldIcon.setHorizontalAlignment(SwingConstants.CENTER);
        fieldIcon.setIcon(new ImageIcon(iconPath));
        fieldIcon.setBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 1, ColorPalette.CREAM)
        );
        fieldIcon.setOpaque(true);

        return fieldIcon;
    }
}
