package app.views.components.dashboard;

import java.awt.*;

public class SearchPanel extends DashboardSection {

    private static final SearchPanel instance = new SearchPanel();

    private SearchPanel() {
        this.setBackground(Color.CYAN);
    }

    public static SearchPanel getInstance() {
        return instance;
    }
}
