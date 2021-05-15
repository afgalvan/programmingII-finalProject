package app.view;

import app.models.Process;
import java.util.LinkedHashMap;
import lombok.Getter;
import lombok.val;

@Getter
public class AddProcessMenu implements Menu {

    private MenuBuilder builder;
    private final Displayable last;
    private Process process;
    private ProcessMetadataRegister processMetadataRegister;
    private DocumentRegister documentRegister;

    public AddProcessMenu(Displayable last) {
        this.last = last;
    }

    @Override
    public void initMenu() {
        val addingProcessOptions = new LinkedHashMap<String, Runnable>();

        addingProcessOptions.put(
            "Agregar fila",
            () -> {
                process.setNotebooksList(documentRegister.registration());
                this.display();
            }
        );
        addingProcessOptions.put(
            "Mostrar documentos",
            () -> {
                View.clear();
                new ProcessMetadataTable(null, process).display(false);
                System.out.println();
                new DocumentTable(null, process).display(false);
                View.waitForEnter();
                this.display();
            }
        );
        addingProcessOptions.put("", View::pass);
        addingProcessOptions.put("Volver", last::display);

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

    public Process getProcessToAdd() {
        this.process = new Process();
        this.documentRegister = new DocumentRegister(process);
        this.processMetadataRegister = new ProcessMetadataRegister(process);
        initMenu();
        this.display();
        System.out.println(process.getNotebooksList());
        View.waitForEnter();
        return this.process;
    }
}
