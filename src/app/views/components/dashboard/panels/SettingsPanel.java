package app.views.components.dashboard.panels;

import app.views.components.atomic.Clickable;
import app.views.components.factory.LabelFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SettingsPanel extends CenterPanel {

    private JLabel usersTitle;
    private List<Clickable> usersOptions;
    private JLabel securityTitle;
    private List<Clickable> securityOptions;

    private static final SettingsPanel instance = new SettingsPanel();

    private SettingsPanel() {
        this.initComponents();
    }

    public static SettingsPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        this.usersOptions = new ArrayList<>();
        this.securityOptions = new ArrayList<>();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 60));

        this.usersTitle = LabelFactory.sectionTitle("Usuario");
        this.usersOptions.add(LabelFactory.option("Cambiar nombre de usuario"));
        this.securityTitle = LabelFactory.sectionTitle("Seguridad");
        this.securityOptions.add(LabelFactory.option("Cambiar contraseña"));

        this.add(usersTitle);
        this.usersOptions.forEach(this::add);
        this.add(securityTitle);
        this.securityOptions.forEach(this::add);
    }
}
