package app.services;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.repositories.IProcessRepository;
import app.repositories.ProcessRepository;
import java.sql.SQLException;
import java.util.List;

public class ProcessService implements IProcessService {

    private final IProcessRepository processRepository;

    public ProcessService() {
        this.processRepository = new ProcessRepository();
    }

    @Override
    public ServiceResponse<Process> insert(Process process) {
        try {
            processRepository.insert(process);
            return new ServiceResponse<>(process);
        } catch (SQLException | DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<List<Process>> getAll() {
        try {
            return new ServiceResponse<>(processRepository.getAll());
        } catch (Exception error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> getById(Long id) {
        try {
            return new ServiceResponse<>(processRepository.getById(id));
        } catch (SQLException | DataAccessException error) {
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
        } catch (SQLException | DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<List<Process>> getProcessByJudged(String name) {
        try {
            return new ServiceResponse<>(processRepository.getProcessByJudged(name));
        } catch (SQLException | DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }

    @Override
    public ServiceResponse<Process> getProcessByProsecutor(String name) {
        try {
            return new ServiceResponse<>(processRepository.getProcessByProsecutor(name));
        } catch (SQLException | DataAccessException error) {
            return new ServiceResponse<>(error.getMessage());
        }
    }
}
