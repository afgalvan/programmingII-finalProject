package app.view;

import app.controllers.ProcessController;
import app.models.Process;
import lombok.Getter;
import lombok.val;

import java.util.LinkedHashMap;

@Getter
public class AddProcessMenu implements Menu {

    private MenuBuilder builder;
    private final ProcessController processController;
    private final Displayable last;
    private final Process process;
    private final ProcessMetadataRegister processMetadataRegister;
    private final DocumentRegister documentRegister;
    private final DocumentTable documentTable;

    public AddProcessMenu(Displayable last, Process process) {
        this.processController = new ProcessController();
        this.last = last;
        this.process = process;
        this.documentRegister = new DocumentRegister(this, process);
        this.processMetadataRegister = new ProcessMetadataRegister(process);
        this.documentTable = new DocumentTable(this, process);
        initMenu();
    }

    @Override
    public void initMenu() {
        val addingProcessOptions = new LinkedHashMap<String, Runnable>();

        addingProcessOptions.put("Agregar fila", documentRegister::registration);
        addingProcessOptions.put("Mostrar documentos", documentTable::display);
        addingProcessOptions.put("", View::pass);
        addingProcessOptions.put(
            "Volver",
            () -> {
                processController.add(process);
                last.display();
            }
        );

        this.builder = new MenuBuilder("EXPEDIENTE JUDICIAL", addingProcessOptions);
    }

    @Override
    public void display() {
        if (process.getMetadata() == null) {
            processMetadataRegister.register();
        }
        View.clear();
        builder.display();
    }
}
