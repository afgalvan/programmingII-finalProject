package app.views.assets;

import java.util.function.Function;
import javax.swing.*;

public class ImageUtils {

    public static final String assets = "src/app/views/assets/";

    public static final Function<String, String> image = imageName ->
        assets + "images/" + imageName;

    public static final Function<String, String> icon = iconName ->
        assets + "icons/" + iconName;

    public static final Function<String, String> icon24x24 = iconName ->
        ImageUtils.icon.apply("") + "24x24/" + iconName;

    public static Icon getIcon(String icon) {
        return new ImageIcon(ImageUtils.icon.apply(icon));
    }

    public static Icon getIcon24x24(String icon) {
        return new ImageIcon(ImageUtils.icon24x24.apply(icon));
    }
}
