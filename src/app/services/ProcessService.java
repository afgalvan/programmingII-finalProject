package app.services;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.repositories.ProcessRepository;
import java.util.List;

public class ProcessService implements Service<Long, Process> {

    private final ProcessRepository processRepository;

    public ProcessService() {
        this.processRepository = new ProcessRepository();
    }

    @Override
    public ServiceResponse<Process> create(Process process) {
        try {
            processRepository.create(process);
            return new ServiceResponse<>(process);
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<List<Process>> readAll() {
        try {
            return new ServiceResponse<>(processRepository.readAll());
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> readById(Long id) {
        try {
            return new ServiceResponse<>(processRepository.readById(id));
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> updateById(Long id, Process newData) {
        return null;
    }

    @Override
    public ServiceResponse<Process> deleteById(Long id) {
        try {
            Process process = processRepository.readById(id);
            processRepository.deleteById(id);
            return new ServiceResponse<>(process);
        } catch (DataAccessException error) {
            return new ServiceResponse<>();
        }
    }
}
