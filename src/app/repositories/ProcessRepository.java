package app.repositories;

import app.database.FileComposer;
import app.database.IFileComposer;
import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.metadata.parts.Person;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ProcessRepository implements IProcessRepository {

    private Map<Long, Process> processMap;
    private final IFileComposer database;

    public ProcessRepository() {
        this.processMap = new LinkedHashMap<>();
        this.database = new FileComposer("src/app/database/Process.obj");
    }

    @Override
    public boolean contains(Long id) {
        try {
            return getById(id) != null;
        } catch (DataAccessException notFound) {
            return false;
        }
    }

    private Map<Long, Process> mappedRead() {
        @SuppressWarnings("unchecked")
        Map<Long, Process> mappedProcesses = (Map<Long, Process>) database.read();
        return mappedProcesses;
    }

    @Override
    public void insert(Process process) throws DataAccessException {
        if (process == null) {
            throw new DataAccessException("El proceso es null");
        }
        if (process.getMetadata() == null) {
            throw new DataAccessException("El proceso no tiene metadata registrado");
        }
        if (process.getMetadata().getId() == null) {
            throw new DataAccessException(
                "El proceso tiene un numero de radicado inválido"
            );
        }

        if (contains(process.getMetadata().getId())) {
            throw new DataAccessException("Id del proceso está repetido.");
        }
        processMap = this.mappedRead();
        if (processMap == null) {
            processMap = new LinkedHashMap<>();
        }
        processMap.put(process.getMetadata().getId(), process);
        database.save(processMap);
    }

    @Override
    public List<Process> getAll() throws DataAccessException {
        processMap = this.mappedRead();
        if (processMap == null) {
            throw new DataAccessException("No existen procesos registrados.");
        }
        return new ArrayList<>(processMap.values());
    }

    @Override
    public Process getById(Long id) throws DataAccessException {
        processMap = this.mappedRead();
        if (processMap == null) {
            throw new DataAccessException("No existen procesos registrados");
        }
        Process process = processMap.get(id);
        if (process == null) {
            throw new DataAccessException("Proceso no encontrado");
        }
        return process;
    }

    @Override
    public void updateById(Long id, Process newData) throws DataAccessException {
        processMap = this.mappedRead();
        getById(id);
        processMap.put(id, newData);
        database.save(processMap);
    }

    @Override
    public void deleteById(Long id) throws DataAccessException {
        processMap = this.mappedRead();
        getById(id);
        processMap.remove(id);
        database.save(processMap);
    }

    private boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    private List<Process> getProcessesByTrial(
        String name,
        Function<Process, List<Person>> getTrialMethod
    ) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        // prettier-ignore-start
        BiConsumer<Process, List<Process>> search = (process, list) ->
            getTrialMethod.apply(process).forEach(person -> {
                if (containsIgnoreCase(person.getFullName(), name)) {
                    list.add(process);
                }
            });
        // prettier-ignore-end

        List<Process> matchList = new ArrayList<>();
        List<Process> allProcess = this.getAll();
        allProcess.forEach(process -> search.accept(process, matchList));

        if (matchList.size() == 0) {
            throw new DataAccessException("Ningún proceso encontrado");
        }

        return matchList;
    }

    @Override
    public List<Process> getProcessesByJudged(String name) throws DataAccessException {
        Function<Process, List<Person>> getJudgedList = Process::getJudgedList;
        return getProcessesByTrial(name, getJudgedList);
    }

    @Override
    public List<Process> getProcessByProsecutor(String name) throws DataAccessException {
        Function<Process, List<Person>> getProsecutorList = Process::getProsecutorList;
        return getProcessesByTrial(name, getProsecutorList);
    }
}
