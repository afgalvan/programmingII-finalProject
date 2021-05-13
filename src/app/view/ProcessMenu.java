package app.view;

import app.models.Process;
import lombok.val;

import java.util.LinkedHashMap;

public class ProcessMenu implements Menu {

    private final AddProcessMenu addProcessMenu;
    private final Displayable last;
    private MenuBuilder processMenu;

    public ProcessMenu(Displayable last) {
        this.addProcessMenu = new AddProcessMenu(last, new Process());
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val processOptions = new LinkedHashMap<String, Runnable>();

        processOptions.put("Agregar proceso", addProcessMenu::display);
        processOptions.put("Editar proceso", View::pass);
        processOptions.put("Eliminar proceso", View::pass);
        processOptions.put("", View::pass);
        processOptions.put("Volver", last::display);

        processMenu = new MenuBuilder("PANEL DE EXPEDIENTE", processOptions);
    }

    @Override
    public void display() {
        View.clear();
        processMenu.display();
    }
}
