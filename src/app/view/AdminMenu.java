package app.view;

import java.util.LinkedHashMap;
import lombok.val;

public class AdminMenu implements Menu {

    private MenuBuilder adminPanelMenu;
    private final RegisterSubOptionMenu registerSubOptionsMenu;
    private final UserSubOptionMenu userSubOptionsMenu;
    private final Displayable last;

    public AdminMenu(Displayable last) {
        this.registerSubOptionsMenu = new RegisterSubOptionMenu(this);
        this.userSubOptionsMenu = new UserSubOptionMenu(this);
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val adminPanelOption = new LinkedHashMap<String, Runnable>();

        adminPanelOption.put("Registro", registerSubOptionsMenu::display);
        adminPanelOption.put("Usuario", userSubOptionsMenu::display);
        adminPanelOption.put("", View::pass);
        adminPanelOption.put("Volver", last::display);

        adminPanelMenu = new MenuBuilder("PANEL DE ADMINISTRACION", adminPanelOption);
    }

    @Override
    public void display() {
        View.clear();
        adminPanelMenu.display();
    }
}
