package app.services;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.repositories.ProcessRepository;
import java.util.List;

public class ProcessService implements IProcessService {

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
    public ServiceResponse<Process> getById(Long id) {
        try {
            return new ServiceResponse<>(processRepository.getById(id));
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
            Process process = processRepository.getById(id);
            processRepository.deleteById(id);
            return new ServiceResponse<>(process);
        } catch (DataAccessException error) {
            return new ServiceResponse<>();
        }
    }

    @Override
    public ServiceResponse<Process> getProcessByJudged(String name) {
        try {
            return new ServiceResponse<>(processRepository.getProcessByJudged(name));
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> getProcessByProsecutor(String name) {
        try {
            return new ServiceResponse<>(processRepository.getProcessByProsecutor(name));
        } catch (DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }
}
