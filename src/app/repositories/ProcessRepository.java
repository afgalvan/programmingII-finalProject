package app.repositories;

import app.database.ProcessFileManager;
import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.metadata.parts.Person;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcessRepository implements IProcessRepository {

    private Map<Long, Process> processMap;
    private final ProcessFileManager database;

    public ProcessRepository() {
        this.processMap = new LinkedHashMap<>();
        this.database = new ProcessFileManager();
    }

    public boolean contains(Long id) {
        try {
            return getById(id) != null;
        } catch (DataAccessException notFound) {
            return false;
        }
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
            throw new DataAccessException("Id del proceso está repetido");
        }
        processMap = database.read();
        if (processMap == null) {
            processMap = new LinkedHashMap<>();
        }
        processMap.put(process.getMetadata().getId(), process);
        database.save(processMap);
    }

    @Override
    public List<Process> getAll() throws DataAccessException {
        processMap = database.read();
        if (processMap == null) {
            throw new DataAccessException("Unable to get enough information.");
        }
        return new ArrayList<>(processMap.values());
    }

    @Override
    public Process getById(Long id) throws DataAccessException {
        processMap = database.read();
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
        processMap = database.read();
        getById(id);
        processMap.put(id, newData);
        database.save(processMap);
    }

    @Override
    public void deleteById(Long id) throws DataAccessException {
        processMap = database.read();
        getById(id);
        processMap.remove(id);
        database.save(processMap);
    }

    private boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    @Override
    public List<Process> getProcessByJudged(String name) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        List<Process> allProcess = this.getAll();
        List<Process> processList = new ArrayList<>();
        for (Process process : allProcess) {
            for (Person person : process.getMetadata().getJudgedList()) {
                if (containsIgnoreCase(person.getName(), name)) {
                    processList.add(process);
                }
            }
        }

        if (processList.size() == 0) {
            throw new DataAccessException("Ningún proceso encontrado");
        }

        return processList;
    }

    @Override
    public Process getProcessByProsecutor(String name) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        List<Process> allProcess = this.getAll();
        for (Process process : allProcess) {
            for (Person person : process.getMetadata().getProsecutorList()) {
                if (person.getFullName().equalsIgnoreCase(name)) {
                    return process;
                }
            }
        }

        throw new DataAccessException("Proceso no encontrado");
    }
}
