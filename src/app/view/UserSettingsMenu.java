package app.view;

import lombok.val;

import java.util.LinkedHashMap;

public class UserSettingsMenu implements Menu {

    private final Displayable last;

    private MenuBuilder configurationMenu;

    public UserSettingsMenu(Displayable last) {
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val configurationOptions = new LinkedHashMap<String, Runnable>();

        configurationOptions.put("Cambiar nombre de usuario", this::changeUsername);
        configurationOptions.put("Cambiar contraseña", this::changePassword);
        configurationOptions.put("", View::pass);
        configurationOptions.put("Volver", last::display);

        configurationMenu = new MenuBuilder("CONFIGURACION", configurationOptions);
    }

    @Override
    public void display() {
        View.clear();
        configurationMenu.display();
    }

    public void changeUsername() {}

    public void changePassword() {}
}
