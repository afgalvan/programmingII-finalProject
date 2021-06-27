package app.views.components.atomic;

import app.views.ColorPalette;
import java.awt.*;
import rojerusan.RSTableMetro;

public class Table extends RSTableMetro {

    public Table() {
        this.setColorBackgoundHead(ColorPalette.PINK_20);
        this.setColorFilasForeground1(ColorPalette.CLAY);
        this.setColorSelBackgound(this.getColorFilasForeground1());
        this.setColorSelForeground(Color.WHITE);
        this.setColorFilasBackgound2(ColorPalette.PINK);
        this.setColorFilasForeground2(ColorPalette.BLUE_20);

        this.setFuenteHead(new Font("Segoe UI", Font.PLAIN, 14));
        this.setColorForegroundHead(ColorPalette.GRAY);
        this.setColorBordeHead(ColorPalette.GRAY);
        this.setAltoHead(35);
        this.setDefaultEditor(Object.class, null);
        this.setMultipleSeleccion(true);
    }
}
