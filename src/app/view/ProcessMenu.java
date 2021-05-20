package app.view;

import app.controllers.ProcessController;
import java.util.LinkedHashMap;
import lombok.val;

public class ProcessMenu implements Menu {

    private final AddProcessMenu addProcessMenu;
    private final ProcessController processController;
    private final Displayable last;
    private MenuBuilder processMenu;

    public ProcessMenu(Displayable last) {
        this.processController = ProcessController.getInstance();
        this.addProcessMenu = new AddProcessMenu(this);
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val processOptions = new LinkedHashMap<String, Runnable>();

        processOptions.put(
            "Agregar proceso",
            () -> processController.add(addProcessMenu.getProcessToAdd())
        );
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
