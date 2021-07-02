package app.views.components.dashboard.panels;

import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;

public class AboutPanel extends CenterPanel {

    private static final AboutPanel instance = new AboutPanel();

    private AboutPanel() {
        this.initComponents();
    }

    public static AboutPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        JPanel infoContainer = new JPanel();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 60));

        JLabel javaInfo = LabelFactory.createLabel(this.javaInfo(), Color.BLACK);
        JLabel OSInfo = LabelFactory.createLabel(this.OSInfo(), Color.BLACK);
        JLabel appVersion = LabelFactory.createLabel(this.appVersion(), Color.BLACK);

        infoContainer.add(javaInfo);
        infoContainer.add(OSInfo);
        infoContainer.add(appVersion);
        infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.PAGE_AXIS));
        infoContainer.setBackground(this.getBackground());
        this.add(infoContainer, BorderLayout.PAGE_END);
    }

    public String javaInfo() {
        return (
            System.getProperty("java.vm.name") + " " + System.getProperty("java.version")
        );
    }

    public String OSInfo() {
        return (
            System.getProperty("os.name") +
            ' ' +
            System.getProperty("os.arch") +
            " (" +
            System.getProperty("os.version") +
            ')'
        );
    }

    public String appVersion() {
        return "1.0.0 - Beta";
    }
}
