package app.views.components.dashboard;

import app.models.Session;
import app.views.Window;
import app.views.components.atomic.Dialog;
import app.views.components.auth.AuthWindow;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;

public class MainWindow extends Window {

    private final TopBar topBar;
    private final MenuBar menuBar;
    private final Session session;

    @Setter
    @Getter
    private DashboardSection dashboardSection;

    public MainWindow(Session session) {
        this.session = session;
        this.topBar = new TopBar(this);
        this.menuBar = new MenuBar();
        this.dashboardSection = new DashboardHome();
        this.initComponents();
        this.addInteraction();
    }

    public void initComponents() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.add(topBar, BorderLayout.PAGE_START);
        this.add(menuBar, BorderLayout.LINE_START);
        this.add(dashboardSection, BorderLayout.CENTER);
    }

    public void exitSession() {
        new Dialog(
            this,
            "Cerrar sesión",
            "¿Deseas cerrar sesión?",
            JOptionPane.WARNING_MESSAGE
        );
        this.setVisible(false);
        AuthWindow login = new AuthWindow();
        login.setVisible(true);
    }

    public void addInteraction() {
        this.topBar.getSignOutButton().onClick(this::exitSession);
    }
}
