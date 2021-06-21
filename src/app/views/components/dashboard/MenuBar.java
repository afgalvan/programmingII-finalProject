package app.views.components.dashboard;

import app.views.ColorPalette;
import app.views.assets.IconUtils;
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

    private List<MenuOption> optionList;

    public MenuBar() {
        this.optionList = new ArrayList<>();
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
    }

    public void createOptionOf(
        String iconName,
        String title,
        DashboardSection dashboardSection
    ) {
        Icon icon = new ImageIcon(IconUtils.icon24x24.apply(iconName));
        val option = new MenuOption(icon, title, dashboardSection);
        this.addInteraction(option);
        this.optionList.add(option);
    }

    public void fillOptions() {
        createOptionOf("home.png", "Dashboard", HomePanel.getInstance());
        createOptionOf("visibility.png", "Panel de consultas", SearchPanel.getInstance());
        createOptionOf("book.png", "Panel de expediente", DocumentsPanel.getInstance());
        createOptionOf("admin.png", "Panel de administracion", AdminPanel.getInstance());
        createOptionOf("settings.png", "Configuración", SettingsPanel.getInstance());
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

    private void addInteraction(MenuOption menuOption) {
        menuOption.onClick(() -> render(menuOption.getSection()));
        menuOption.getPressItem().onClick(menuOption.getRunnable());
    }

    private void render(DashboardSection dashboardSection) {
        MainWindow mainWindow = MainWindow.state;
        mainWindow.renderDashboard(dashboardSection);
        this.optionList.forEach(MenuOption::configureColor);
    }
}
