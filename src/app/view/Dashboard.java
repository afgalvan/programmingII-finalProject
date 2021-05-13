package app.view;

import app.models.Session;
import app.models.users.SuperUser;
import java.util.LinkedHashMap;
import lombok.Getter;
import lombok.val;

public class Dashboard implements Menu {

    private MenuBuilder dashboardMenu;
    private final AdminMenu adminMenu;
    private final UserSettingsMenu userSettingsMenu;
    private final EnquiryMenu enquiryMenu;

    @Getter
    private final Session currentSession;

    public Dashboard(Session session) {
        this.currentSession = session;
        this.adminMenu = new AdminMenu(this);
        this.userSettingsMenu = new UserSettingsMenu(this);
        this.enquiryMenu = new EnquiryMenu(this);
        initMenu();
    }

    @Override
    public void initMenu() {
        val dashboardOptions = new LinkedHashMap<String, Runnable>();

        dashboardOptions.put("Panel de consultas", enquiryMenu::display);
        if (this.currentSession.getUser() != null) {
            dashboardOptions.put("Panel de expedientes", new ProcessMenu(this)::display);
        }
        if (this.currentSession.getUser() instanceof SuperUser) {
            dashboardOptions.put("Panel de administracion", adminMenu::display);
        }
        if (this.currentSession.getUser() != null) {
            dashboardOptions.put("Configuracion", userSettingsMenu::display);
        }
        dashboardOptions.put("", View::pass);
        dashboardOptions.put("Cerrar Sesion", new LoginMenu()::display);

        dashboardMenu = new MenuBuilder("DASHBOARD", dashboardOptions);
    }

    @Override
    public void display() {
        View.clear();
        dashboardMenu.display();
    }
}
