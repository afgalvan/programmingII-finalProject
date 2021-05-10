package app.services;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.repositories.ProcessRepository;
import java.util.List;

public class ProcessService implements Service<Integer, Process> {

    ProcessRepository processRepository;

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
    public ServiceResponse<Process> readById(Integer id) {
        try {
            return new ServiceResponse<>(processRepository.readById(id));
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> updateById(Integer id, Process newData) {
        return null;
    }

    @Override
    public ServiceResponse<Process> deleteById(Integer id) {
        try {
            Process process = processRepository.readById(id);
            processRepository.deleteById(id);
            return new ServiceResponse<>(process);
        } catch (DataAccessException error) {
            return new ServiceResponse<>();
        }
    }
}
