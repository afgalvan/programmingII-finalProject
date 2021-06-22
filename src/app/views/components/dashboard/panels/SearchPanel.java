package app.views.components.dashboard.panels;

import java.awt.*;

public class SearchPanel extends CenterPanel {

    private static final SearchPanel instance = new SearchPanel();

    private SearchPanel() {
        this.setBackground(Color.CYAN);
    }

    public static SearchPanel getInstance() {
        return instance;
    }
}
