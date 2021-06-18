package app.views;

import app.views.components.auth.AuthWindow;
import app.views.components.dashboard.MainWindow;

public class View {

    public View() {
        Window window = new MainWindow();
        window.setVisible(true);
    }
}
