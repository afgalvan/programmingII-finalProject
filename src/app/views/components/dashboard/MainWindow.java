package app.views.components.dashboard;

import app.models.Session;
import app.views.Window;
import java.awt.*;
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
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.topBar = new TopBar(this);
        this.menuBar = new MenuBar();
        this.dashboardSection = new DashboardHome();
        this.session = session;
        initComponents();
    }

    public void initComponents() {
        this.add(topBar, BorderLayout.PAGE_START);
        this.add(menuBar, BorderLayout.LINE_START);
        this.add(dashboardSection, BorderLayout.CENTER);
    }
}
