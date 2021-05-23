package app.services;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.Response;
import app.models.annotations.Testable;
import app.repositories.IProcessRepository;
import app.repositories.ProcessRepository;
import java.sql.SQLException;
import java.util.List;
import test.services.ProcessServiceTest;

@Testable(testClass = ProcessServiceTest.class)
public class ProcessService implements IProcessService {

    private final IProcessRepository processRepository;

    public ProcessService() {
        this.processRepository = new ProcessRepository();
    }

    @Override
    public boolean contains(Long id) {
        return processRepository.contains(id);
    }

    @Override
    public Response<Process> insert(Process process) {
        try {
            processRepository.insert(process);
            return new Response<>(process);
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }

    @Override
    public Response<List<Process>> getAll() {
        try {
            return new Response<>(processRepository.getAll());
        } catch (Exception error) {
            return new Response<>(error.getMessage());
        }
    }

    @Override
    public Response<Process> getById(Long id) {
        try {
            return new Response<>(processRepository.getById(id));
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }

    @Override
    public Response<Process> updateById(Long id, Process newData) {
        return null;
    }

    @Override
    public Response<Process> deleteById(Long id) {
        try {
            Process process = processRepository.getById(id);
            processRepository.deleteById(id);
            return new Response<>(process);
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }

    @Override
    public Response<List<Process>> getProcessesByJudged(String name) {
        try {
            return new Response<>(processRepository.getProcessesByJudged(name));
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }

    @Override
    public Response<List<Process>> getProcessesByProsecutor(String name) {
        try {
            return new Response<>(processRepository.getProcessByProsecutor(name));
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }
}
