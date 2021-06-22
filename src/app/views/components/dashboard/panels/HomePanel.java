package app.views.components.dashboard.panels;

import app.views.ColorPalette;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import lombok.val;
import rojerusan.RSMaterialButtonRectangle;
import rojerusan.RSTableMetro;

public class HomePanel extends CenterPanel {

    private final RSTableMetro table;
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
    private final RSMaterialButtonRectangle totalDocumentsContainer;
    private final RSMaterialButtonRectangle currentUserContainer;

    private static final HomePanel instance = new HomePanel();

    public static HomePanel getInstance() {
        return instance;
    }

    private HomePanel() {
        this.table = new RSTableMetro();
        this.tableContainer = new JScrollPane();
        this.statisticsContainer = new JPanel();
        this.totalDocumentsContainer = new RSMaterialButtonRectangle();
        this.currentUserContainer = new RSMaterialButtonRectangle();
        this.initComponents();
    }

    public void initComponents() {
        this.setLayout(new GridLayout(2, 0, 10, 0));
        this.setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 50));
        this.initStatisticsView();
        this.initTableView();
    }

    public void initStatisticsView() {
        this.totalDocumentsContainer.setBackground(Color.WHITE);
        this.currentUserContainer.setBackground(
                this.totalDocumentsContainer.getBackground()
            );

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
        this.table.setColorBackgoundHead(ColorPalette.PINK_20);
        this.table.setFuenteHead(new Font("Segoe UI", Font.PLAIN, 14));
        this.table.setColorForegroundHead(ColorPalette.GRAY);
        this.table.setColorBordeHead(ColorPalette.GRAY);
        this.table.setAltoHead(35);
        this.table.setMultipleSeleccion(true);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(150);
        this.tableContainer.setViewportView(table);
        this.add(tableContainer);
    }
}
