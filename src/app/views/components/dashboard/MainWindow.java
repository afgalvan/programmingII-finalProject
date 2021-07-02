package app.views.components.dashboard;

import app.models.Session;
import app.views.Window;
import app.views.components.atomic.Dialog;
import app.views.components.auth.AuthWindow;
import app.views.components.dashboard.panels.CenterPanel;
import app.views.components.dashboard.panels.HomePanel;
import java.awt.*;
import lombok.Getter;
import lombok.Setter;

public class MainWindow extends Window {

    private final TopBar topBar;
    private final MenuBar menuBar;

    @Getter
    private final Session session;

    public static MainWindow state;

    @Setter
    @Getter
    private CenterPanel dashboardSection;

    public MainWindow(Session session) {
        this.session = session;
        this.topBar = new TopBar();
        this.dashboardSection = HomePanel.getInstance();
        this.dashboardSection.setVisible(true);
        this.menuBar = new MenuBar(session);
        this.initComponents();
        this.addInteraction();
        MainWindow.state = this;
    }

    public void initComponents() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.addComponents();
    }

    public void addComponents() {
        this.add(this.topBar, BorderLayout.PAGE_START);
        this.add(this.dashboardSection, BorderLayout.CENTER);
        this.add(this.menuBar, BorderLayout.LINE_START);
    }

    public void renderPanel(CenterPanel dashboardSection) {
        this.dashboardSection.setVisible(false);
        this.remove(this.dashboardSection);

        dashboardSection.setVisible(true);
        this.dashboardSection = dashboardSection;
        this.add(this.dashboardSection, BorderLayout.CENTER);

        this.validate();
        this.repaint();
    }

    public void exitSession() {
        int choice = Dialog.showConfirm(
            this,
            "Cerrar sesión",
            "¿Deseas cerrar sesión?",
            Dialog.WARNING_MESSAGE
        );

        if (choice == Dialog.YES_OPTION) {
            this.session.end();
            this.dashboardSection.setVisible(false);
            CenterPanel.recreate();
            this.dispose();
            AuthWindow login = new AuthWindow();
            login.setVisible(true);
        }
    }

    public void addInteraction() {
        this.topBar.getSignOutButton().onClick(this::exitSession);
    }
}
