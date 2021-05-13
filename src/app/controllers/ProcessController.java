package app.controllers;

import app.models.Process;
import app.services.IProcessService;
import app.services.ProcessService;
import app.services.ServiceResponse;

import java.util.List;

/**
 *
 */
public class ProcessController {

    private final IProcessService service;

    public ProcessController() {
        this.service = new ProcessService();
    }

    /**
     *
     * @param process process to be stored in database.
     * @return A response of the save operation.
     */
    public DialogResponse<Process> add(Process process) {
        ServiceResponse<Process> response = service.insert(process);
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
        ServiceResponse<Process> response = service.getById(id);
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

    public DialogResponse<List<Process>> getProcessByJudged(String name) {
        ServiceResponse<List<Process>> response = service.getProcessByJudged(name);
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

    public DialogResponse<Process> getProcessByProsecutor(String name) {
        ServiceResponse<Process> response = service.getProcessByProsecutor(name);
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
