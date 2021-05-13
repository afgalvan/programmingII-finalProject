package app.controllers;

import app.models.Process;
import app.services.ProcessService;
import app.services.ServiceResponse;

/**
 *
 */
public class ProcessController {

    private final ProcessService service;

    public ProcessController() {
        this.service = new ProcessService();
    }

    /**
     *
     * @param process
     * @return
     */
    public DialogResponse<Process> add(Process process) {
        ServiceResponse<Process> response = service.create(process);
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

    public DialogResponse<Process> getProcessByJudged(String name) {
        ServiceResponse<Process> response = service.getProcessByJudged(name);
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
