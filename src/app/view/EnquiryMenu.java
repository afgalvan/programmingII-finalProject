package app.view;

import app.controllers.DialogResponse;
import app.controllers.ProcessController;
import app.models.Process;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.val;

public class EnquiryMenu implements Menu {

    private MenuBuilder enquiryMenu;
    private final Displayable last;
    private final ProcessController controller;

    public EnquiryMenu(Displayable last) {
        this.last = last;
        this.controller = new ProcessController();
        initMenu();
    }

    @Override
    public void initMenu() {
        val enquiryOptions = new LinkedHashMap<String, Runnable>();

        enquiryOptions.put("Buscar por radicado", this::findProcessById);
        enquiryOptions.put("Buscar por demandado", this::findProcessByJudged);
        enquiryOptions.put("Buscar por demandante", this::findProcessByProsecutor);
        enquiryOptions.put("", View::pass);
        enquiryOptions.put("Volver", last::display);

        enquiryMenu = new MenuBuilder("CONSULTAR PROCESO", enquiryOptions);
    }

    @Override
    public void display() {
        View.clear();
        enquiryMenu.display();
    }

    public void findProcessById() {
        View.clear();
        Long id = View.input("Ingrese el id: ", View.scanner::nextLong);
        DialogResponse<Process> response = controller.getProcessById(id);
        displaySingleProcess(response.getData(), response.getMessage());
    }

    public void findProcessByJudged() {
        View.clear();
        System.out.print("Ingrese el nombre: ");
        String name = View.scanner.nextLine();
        DialogResponse<List<Process>> response = controller.getProcessesByJudged(name);
        displayManyProcesses(response.getData(), response.getMessage());
    }

    public void findProcessByProsecutor() {
        View.clear();
        System.out.print("Ingrese el nombre: ");
        String name = View.scanner.nextLine();
        DialogResponse<List<Process>> response = controller.getProcessesByProsecutor(
            name
        );
        displayManyProcesses(response.getData(), response.getMessage());
    }

    public void displaySingleProcess(Process process, String errorMessage) {
        if (process != null) {
            showProcess(process);
        } else {
            System.out.println(errorMessage);
            View.waitForEnter();
        }
        this.display();
    }

    public void displayManyProcesses(List<Process> processList, String errorMessage) {
        if (processList != null && processList.size() != 0) {
            processList.forEach(this::showProcess);
        } else {
            System.out.println(errorMessage);
            View.waitForEnter();
        }
        this.display();
    }

    public void showProcess(Process process) {
        new ProcessMetadataTable(null, process).display(false);
        System.out.println();
        new DocumentTable(null, process).display(false);
        View.waitForEnter();
    }
}
