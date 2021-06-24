package app.views.components.dashboard.panels;

import app.views.components.atomic.Clickable;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AdminPanel extends CenterPanel {

    private JPanel adminOptionsContainer;
    private JLabel registerTitle;
    private List<Clickable> registerOptions;
    private JLabel usersTitle;
    private List<Clickable> usersOptions;

    private static final AdminPanel instance = new AdminPanel();

    private AdminPanel() {
        this.initComponents();
    }

    public static AdminPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.adminOptionsContainer = new JPanel();
        this.registerOptions = new ArrayList<>();
        this.usersOptions = new ArrayList<>();

        this.adminOptionsContainer.setBackground(this.getBackground());
        this.adminOptionsContainer.setBorder(
                BorderFactory.createEmptyBorder(0, 60, 20, 60)
            );
        this.adminOptionsContainer.setLayout(
                new BoxLayout(this.adminOptionsContainer, BoxLayout.PAGE_AXIS)
            );

        this.initRegisterOptions();
        this.initUsersOptions();
        this.add(adminOptionsContainer, BorderLayout.CENTER);
    }

    public void initRegisterOptions() {
        this.registerTitle = LabelFactory.sectionTitle("Registro");
        this.registerOptions.add(LabelFactory.option("Juzgados"));
        this.registerOptions.add(LabelFactory.option("Despacho judicial"));
        this.registerOptions.add(LabelFactory.option("Serie"));
        this.registerOptions.add(LabelFactory.option("Subserie"));
        this.registerOptions.add(LabelFactory.option("Tipos documentales"));

        this.adminOptionsContainer.add(registerTitle);
        this.registerOptions.forEach(adminOptionsContainer::add);
    }

    public void initUsersOptions() {
        this.usersTitle = LabelFactory.sectionTitle("Usuarios");
        this.usersOptions.add(LabelFactory.option("Crear usuario"));
        this.usersOptions.add(LabelFactory.option("Editar usuario"));
        this.usersOptions.add(LabelFactory.option("Eliminar usuario"));

        this.adminOptionsContainer.add(usersTitle);
        this.usersOptions.forEach(adminOptionsContainer::add);
    }
}
