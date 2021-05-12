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
    public DialogResponse<Process> register(Process process) {
        ServiceResponse<Process> response = service.create(process);
        return new DialogResponse<>(
            "Registro de proceso",
            "Proceso registrado con éxito",
            DialogResponse.INFORMATION_MESSAGE,
            response.getData()
        );
    }
}
