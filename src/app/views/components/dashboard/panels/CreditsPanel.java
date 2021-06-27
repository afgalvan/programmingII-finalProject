package app.views.components.dashboard.panels;

import app.views.components.atomic.Clickable;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class CreditsPanel extends CenterPanel {

    private final String PROJECT_LINK =
        "https://github.com/afgalvan/programmingII-finalProject";
    private final String ANDRES_GITHUB = "https://github.com/afgalvan";
    private final String JAVIER_GITHUB = "https://github.com/jwar28";

    private static final CreditsPanel instance = new CreditsPanel();

    private CreditsPanel() {
        this.initComponents();
    }

    public static CreditsPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        JPanel credits = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 40, 60));

        Clickable andresInfo = new Clickable(this.getGithub("Andres Galvan"));
        andresInfo.onClick(() -> openLink(ANDRES_GITHUB));

        Clickable javierInfo = new Clickable(this.getGithub("Javier Guerra"));
        javierInfo.onClick(() -> openLink(JAVIER_GITHUB));

        Clickable projectInfo = new Clickable(this.getGithub("Proyecto"));
        projectInfo.onClick(() -> openLink(PROJECT_LINK));

        credits.add(andresInfo);
        credits.add(javierInfo);
        credits.add(projectInfo);
        credits.setBackground(this.getBackground());
        credits.setLayout(new BoxLayout(credits, BoxLayout.PAGE_AXIS));
        this.add(credits);
    }

    public String getGithub(String text) {
        return "<html><a href=\"\">" + text + "</a></html>";
    }

    public void openLink(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
