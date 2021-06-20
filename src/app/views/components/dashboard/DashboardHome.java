package app.views.components.dashboard;

import app.views.ColorPalette;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import lombok.val;
import rojerusan.RSTableMetro;

public class DashboardHome extends DashboardSection {

    private final RSTableMetro table;

    public DashboardHome() {
        this.table = new RSTableMetro();
        val panel = new JScrollPane();
        val model = new DefaultTableModel(
            null,
            new String[] { "Nombre del documento", "Fecha incorporación", "Origen" }
        );
        table.setModel(model);
        table.setColorBackgoundHead(ColorPalette.PINK_20);
        table.setFuenteHead(new Font("Segoe UI", Font.PLAIN, 12));
        table.setColorForegroundHead(ColorPalette.GRAY);
        table.setColorBordeHead(ColorPalette.GRAY);
        panel.setViewportView(table);
        this.add(panel);
    }
}
