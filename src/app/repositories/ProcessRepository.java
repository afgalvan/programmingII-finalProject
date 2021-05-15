package app.repositories;

import app.database.FileManagement;
import app.database.FileManager;
import app.exceptions.DataAccessException;
import app.models.Process;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ProcessRepository implements IProcessRepository {

    private Map<Long, Process> processMap;
    private final FileManagement database;

    public ProcessRepository() {
        this.processMap = new LinkedHashMap<>();
        this.database = new FileManager("src/app/database/Process.obj");
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
        BiConsumer<Process, List<Process>> biConsumer
    ) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        List<Process> processList = new ArrayList<>();
        List<Process> allProcess = this.getAll();
        allProcess.forEach(process -> biConsumer.accept(process, processList));

        if (processList.size() == 0) {
            throw new DataAccessException("Ningún proceso encontrado");
        }

        return processList;
    }

    @Override
    public List<Process> getProcessesByJudged(String name) throws DataAccessException {
        // prettier-ignore-start
        BiConsumer<Process, List<Process>> biConsumer = (process, list) ->
            process.getMetadata().getJudgedList().forEach(person -> {
                if (containsIgnoreCase(person.getFullName(), name)) {
                    list.add(process);
                }
            });
        // prettier-ignore-end

        return getProcessesByTrial(name, biConsumer);
    }

    @Override
    public List<Process> getProcessByProsecutor(String name) throws DataAccessException {
        // prettier-ignore-start
        BiConsumer<Process, List<Process>> biConsumer = (process, list) ->
            process.getMetadata().getProsecutorList().forEach(person -> {
                if (containsIgnoreCase(person.getFullName(), name)) {
                    list.add(process);
                }
            });
        // prettier-ignore-end

        return getProcessesByTrial(name, biConsumer);
    }
}
