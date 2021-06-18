package app.views.components.dashboard;

import app.views.Window;
import java.awt.*;
import lombok.Getter;
import lombok.Setter;

public class MainWindow extends Window {

    private TopBar topBar;
    private MenuBar menuBar;

    @Setter
    @Getter
    private DashboardSection dashboardSection;

    public MainWindow() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.topBar = new TopBar();
        this.menuBar = new MenuBar();
        this.dashboardSection = new DashboardHome();
        initComponents();
    }

    public void initComponents() {
        this.add(topBar, BorderLayout.PAGE_START);
        this.add(menuBar, BorderLayout.LINE_START);
        this.add(dashboardSection, BorderLayout.CENTER);
    }
}
