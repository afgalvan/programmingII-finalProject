package app.repositories;

import app.database.ProcessDatabase;
import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.metadata.parts.Person;
import java.util.*;

public class ProcessRepository implements IProcessRepository {

    private Map<Long, Process> processMap;
    private final ProcessDatabase database;

    public ProcessRepository() {
        this.processMap = new LinkedHashMap<>();
        this.database = new ProcessDatabase();
    }

    public boolean isUnique(Process process) {
        try {
            return getById(process.getMetadata().getId()) == null;
        } catch (DataAccessException notFound) {
            return true;
        }
    }

    @Override
    public void create(Process process) throws DataAccessException {
        if (process == null) {
            throw new DataAccessException("El proceso es null");
        }
        if (process.getMetadata() == null) {
            throw new DataAccessException("El proceso no tiene metadata registrado");
        }

        if (!isUnique(process)) {
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
    public List<Process> readAll() throws DataAccessException {
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
            return null;
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

    @Override
    public Process getProcessByJudged(String name) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        List<Process> allProcess = this.readAll();
        for (Process process : allProcess) {
            for (Person person : process.getMetadata().getJudgedList()) {
                if (person.getFullName().contains(name)) {
                    return process;
                }
            }
        }

        throw new DataAccessException("Proceso no encontrado");
    }

    @Override
    public Process getProcessByProsecutor(String name) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es null");
        }

        List<Process> allProcess = this.readAll();
        for (Process process : allProcess) {
            for (Person person : process.getMetadata().getProsecutorList()) {
                if (person.getFullName().contains(name)) {
                    return process;
                }
            }
        }

        throw new DataAccessException("Proceso no encontrado");
    }
}
