package app.views.components.dashboard;

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

    public MenuBar() {
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
        List<MenuItem> optionList
    ) {
        Icon icon = new ImageIcon(ImageUtils.icon24x24.apply(iconName));
        val option = new MenuItem(icon, title, dashboardSection);
        this.addInteraction(option);
        optionList.add(option);
    }

    public void fillOptions() {
        createOptionOf("home.png", "Dashboard", HomePanel.getInstance(), this.optionList);
        createOptionOf(
            "visibility.png",
            "Panel de consultas",
            SearchPanel.getInstance(),
            this.optionList
        );
        createOptionOf(
            "book.png",
            "Panel de expedientes",
            DocumentsPanel.getInstance(),
            this.optionList
        );
        createOptionOf(
            "admin.png",
            "Panel de administracion",
            AdminPanel.getInstance(),
            this.optionList
        );
        createOptionOf(
            "settings.png",
            "Configuración",
            SettingsPanel.getInstance(),
            this.optionList
        );

        createOptionOf("users.png", "Créditos", CreditsPanel.getInstance(), this.others);
        createOptionOf("info.png", "Acerca de", AboutPanel.getInstance(), this.others);
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
        menuItem.onClick(() -> render(menuItem.getSection()));
        menuItem.getPressItem().onClick(menuItem.getRunnable());
    }

    private void render(CenterPanel dashboardSection) {
        MainWindow mainWindow = MainWindow.state;
        mainWindow.renderPanel(dashboardSection);
        this.optionList.forEach(MenuItem::configureColor);
        this.others.forEach(MenuItem::configureColor);
    }
}
