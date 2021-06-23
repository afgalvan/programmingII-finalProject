package app.views.components.dashboard.panels;

import app.views.ColorPalette;
import app.views.components.atomic.Table;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import lombok.val;
import rojerusan.RSMaterialButtonRectangle;

public class HomePanel extends CenterPanel {

    private final Table table;
    private final String[] tableTitle = {
        "Nombre del documento",
        "Fecha incorporación",
        "Páginas",
        "Formato",
        "Tamaño",
        "Origen",
    };
    private final JScrollPane tableContainer;
    private final JPanel statisticsContainer;

    private static final HomePanel instance = new HomePanel();

    public static HomePanel getInstance() {
        return instance;
    }

    private HomePanel() {
        this.table = new Table();
        this.tableContainer = new JScrollPane();
        this.statisticsContainer = new JPanel();
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setLayout(new GridLayout(2, 0, 10, 0));
        this.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 50));
        this.initStatisticsView();
        this.initTableView();
    }

    public void initStatisticsView() {
        val totalDocumentsContainer = new RSMaterialButtonRectangle();
        val currentUserContainer = new RSMaterialButtonRectangle();

        totalDocumentsContainer.setBackground(Color.WHITE);
        currentUserContainer.setBackground(totalDocumentsContainer.getBackground());

        val sidesPadding = 190;
        val cardContainer = new JPanel(new GridLayout(0, 2, sidesPadding, 10));
        cardContainer.setBackground(this.getBackground());
        cardContainer.add(totalDocumentsContainer);
        cardContainer.add(currentUserContainer);
        cardContainer.setBorder(
            BorderFactory.createEmptyBorder(0, sidesPadding, 60, sidesPadding)
        );

        val title = LabelFactory.createLabel("Dashboard", Color.BLACK, Font.BOLD, 26);
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.CREAM));
        this.statisticsContainer.setLayout(new BorderLayout());
        this.statisticsContainer.setBackground(this.getBackground());
        this.statisticsContainer.add(title, BorderLayout.PAGE_START);
        this.statisticsContainer.add(cardContainer, BorderLayout.CENTER);
        this.add(statisticsContainer);
    }

    public void initTableView() {
        val model = new DefaultTableModel(null, tableTitle);
        this.table.setModel(model);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(150);
        this.tableContainer.setViewportView(table);
        this.add(tableContainer);
    }
}
