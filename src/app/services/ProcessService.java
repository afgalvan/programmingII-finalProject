package app.services;

import static app.utils.Utils.containsIgnoreCase;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.Response;
import app.models.annotations.TestedOn;
import app.models.metadata.parties.TrialParty;
import app.repositories.ProcessRepository;
import app.repositories.SerializationProcessRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import test.services.ProcessServiceTest;

@TestedOn(ProcessServiceTest.class)
@AllArgsConstructor
public class ProcessService implements IProcessService {

    private final ProcessRepository processRepository;

    public ProcessService() {
        this.processRepository = new SerializationProcessRepository();
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
        try {
            processRepository.updateById(id, newData);
            return new Response<>(newData);
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
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

    private boolean matchTrialWithText(List<TrialParty> trialParties, String text) {
        return trialParties
            .stream()
            .anyMatch(trialParty -> containsIgnoreCase(trialParty.getFullName(), text));
    }

    private boolean matchProcessWithText(Process process, String text) {
        return (
            containsIgnoreCase(process.getId().toString(), text) ||
            matchTrialWithText(process.getJudgedList(), text) ||
            matchTrialWithText(process.getProsecutorList(), text)
        );
    }

    private List<Process> getFilteredList(String text)
        throws SQLException, DataAccessException {
        return this.processRepository.getAll()
            .stream()
            .filter(process -> matchProcessWithText(process, text))
            .collect(Collectors.toList());
    }

    @Override
    public Response<List<Process>> filterProcessByAnyMatch(String text) {
        try {
            return new Response<>(this.getFilteredList(text));
        } catch (SQLException | DataAccessException error) {
            return new Response<>(error.getMessage());
        }
    }
}
