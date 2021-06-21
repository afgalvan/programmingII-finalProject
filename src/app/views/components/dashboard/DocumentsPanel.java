package app.views.components.dashboard;

import java.awt.*;

public class DocumentsPanel extends DashboardSection {

    private static final DocumentsPanel instance = new DocumentsPanel();

    private DocumentsPanel() {
        this.setBackground(Color.RED);
    }

    public static DocumentsPanel getInstance() {
        return instance;
    }
}
