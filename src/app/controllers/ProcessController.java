package app.controllers;

import app.models.Process;
import app.models.Response;
import app.services.IProcessService;
import app.services.ProcessService;
import java.util.List;

/**
 *
 */
public class ProcessController {

    private final IProcessService service;
    private static final ProcessController instance = new ProcessController();

    private ProcessController() {
        this.service = new ProcessService();
    }

    public static ProcessController getInstance() {
        return instance;
    }

    public boolean contains(Long id) {
        return service.contains(id);
    }

    /**
     *
     * @param process process to be stored in database.
     * @return A response of the save operation.
     */
    public DialogResponse<Process> add(Process process) {
        Response<Process> response = service.insert(process);
        if (response.isError()) {
            return new DialogResponse<>(
                "Registro de proceso",
                response.getMessage(),
                DialogResponse.ERROR_MESSAGE,
                response.getData()
            );
        }

        return new DialogResponse<>(
            "Registro de proceso",
            "Proceso registrado con éxito",
            DialogResponse.INFORMATION_MESSAGE,
            response.getData()
        );
    }

    public DialogResponse<Process> getProcessById(Long id) {
        Response<Process> response = service.getById(id);
        if (response.isError()) {
            return new DialogResponse<>(
                "Registro de proceso",
                response.getMessage(),
                DialogResponse.ERROR_MESSAGE,
                response.getData()
            );
        }

        return new DialogResponse<>(
            "Busqueda de proceso",
            "Proceso encontrado con éxito",
            DialogResponse.INFORMATION_MESSAGE,
            response.getData()
        );
    }

    public DialogResponse<List<Process>> getProcessesByJudged(String name) {
        Response<List<Process>> response = service.getProcessesByJudged(name);
        if (response.isError()) {
            return new DialogResponse<>(
                "Registro de proceso",
                response.getMessage(),
                DialogResponse.ERROR_MESSAGE,
                response.getData()
            );
        }

        return new DialogResponse<>(
            "Busqueda de proceso",
            "Proceso encontrado con éxito",
            DialogResponse.INFORMATION_MESSAGE,
            response.getData()
        );
    }

    public DialogResponse<List<Process>> getProcessesByProsecutor(String name) {
        Response<List<Process>> response = service.getProcessesByProsecutor(name);
        if (response.isError()) {
            return new DialogResponse<>(
                "Registro de proceso",
                response.getMessage(),
                DialogResponse.ERROR_MESSAGE,
                response.getData()
            );
        }

        return new DialogResponse<>(
            "Busqueda de proceso",
            "Proceso encontrado con éxito",
            DialogResponse.INFORMATION_MESSAGE,
            response.getData()
        );
    }
}
