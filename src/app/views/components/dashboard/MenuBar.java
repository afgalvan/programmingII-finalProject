package app.views.components.dashboard;

import app.models.Session;
import app.models.users.Coordinator;
import app.models.users.SuperUser;
import app.models.users.UserType;
import app.utils.ImageUtils;
import app.views.ColorPalette;
import app.views.components.dashboard.panels.*;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Getter
@Setter
public class MenuBar extends JPanel {

    private List<MenuItem> optionList;
    private List<MenuItem> others;
    private final Session session;

    public MenuBar(Session session) {
        this.session = session;
        this.optionList = new ArrayList<>();
        this.others = new ArrayList<>();
        this.configureLayout();
        this.initComponents();
    }

    public void initComponents() {
        this.setBackground(ColorPalette.BLUE);
        this.setPreferredSize(new Dimension(300, 0));
        this.fillOptions();
        JLabel menuTitle = sectionTitle("Menu");
        JLabel othersTitle = sectionTitle("Otros");

        this.add(menuTitle);
        this.optionList.forEach(this::add);
        this.add(othersTitle);
        this.others.forEach(this::add);
    }

    public void createOptionOf(
        String iconName,
        String title,
        CenterPanel dashboardSection,
        List<MenuItem> optionList,
        UserType permissions
    ) {
        Icon icon = new ImageIcon(ImageUtils.icon24x24.apply(iconName));
        val option = new MenuItem(icon, title, dashboardSection);
        if (permissions == UserType.CO && session.isGuest()) {
            option.setEnabled(false);
        }
        if (permissions == UserType.SU && !(session.getUser() instanceof SuperUser)) {
            option.setEnabled(false);
        }
        this.addInteraction(option);
        optionList.add(option);
    }

    public void fillOptions() {
        createOptionOf("home.png", "Dashboard", HomePanel.getInstance(), this.optionList, null);
        createOptionOf(
            "visibility.png",
            "Panel de consultas",
            SearchPanel.getInstance(),
            this.optionList,
            null
        );
        createOptionOf(
            "book.png",
            "Panel de expedientes",
            DocumentsPanel.getInstance(),
            this.optionList,
            UserType.CO
        );
        createOptionOf(
            "admin.png",
            "Panel de administracion",
            AdminPanel.getInstance(),
            this.optionList,
            UserType.SU
        );
        createOptionOf(
            "settings.png",
            "Configuración",
            SettingsPanel.getInstance(),
            this.optionList,
            UserType.CO
        );

        createOptionOf("users.png", "Créditos", CreditsPanel.getInstance(), this.others, null);
        createOptionOf("info.png", "Acerca de", AboutPanel.getInstance(), this.others, null);
    }

    public void configureLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
    }

    public JLabel sectionTitle(String title) {
        JLabel label = LabelFactory.createLabel(title, ColorPalette.CLAY, Font.BOLD, 22);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        return label;
    }

    private void addInteraction(MenuItem menuItem) {
        menuItem.onClick(() -> {
            if (menuItem.isEnabled()) render(menuItem.getSection());
        });
        menuItem.getPressItem().onClick(menuItem.getRunnable());
    }

    private void render(CenterPanel dashboardSection) {
        MainWindow mainWindow = MainWindow.state;
        mainWindow.renderPanel(dashboardSection);
        this.optionList.forEach(MenuItem::configureColor);
        this.others.forEach(MenuItem::configureColor);
    }
}
