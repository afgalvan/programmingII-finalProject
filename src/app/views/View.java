package app.views;

// import app.models.Session;

import app.views.components.auth.AuthWindow;

// import app.views.components.dashboard.MainWindow;

public class View {

    public View() {
        // Window window = new MainWindow(Session.asGuest());
        Window window = new AuthWindow();
        window.setVisible(true);
    }
}
