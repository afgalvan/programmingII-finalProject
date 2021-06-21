package app.views.assets;

import java.util.function.Function;

public class IconUtils {

    public static final String assets = "src/app/views/assets/";

    public static final Function<String, String> image = imageName ->
        assets + "images/" + imageName;

    public static final Function<String, String> icon = iconName ->
        assets + "icons/" + iconName;

    public static final Function<String, String> icon24x24 = iconName ->
        IconUtils.icon.apply("") + "24x24/" + iconName;
}
