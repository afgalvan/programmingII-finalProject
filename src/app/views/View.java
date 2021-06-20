package app.views;

import app.views.components.auth.AuthWindow;

public class View {

    public View() {
        // Window window = new MainWindow(Session.asGuest());
        Window window = new AuthWindow();
        window.setVisible(true);
    }
}
