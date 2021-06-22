package app.views.components.dashboard.panels;

import java.awt.*;

public class DocumentsPanel extends CenterPanel {

    private static final DocumentsPanel instance = new DocumentsPanel();

    private DocumentsPanel() {
        this.setBackground(Color.RED);
    }

    public static DocumentsPanel getInstance() {
        return instance;
    }
}
