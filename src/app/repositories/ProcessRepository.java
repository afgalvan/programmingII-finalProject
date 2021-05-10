package app.repositories;

import app.exceptions.DataAccessException;
import app.models.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessRepository implements Repository<Integer, Process> {

    private final Map<Integer, Process> database;

    public ProcessRepository() {
        this.database = new HashMap<>();
    }

    @Override
    public void create(Process process) throws DataAccessException {
        if (process == null) {
            throw new DataAccessException("El proceso es null");
        }
        if (readById(process.getId()) != null) {
            throw new DataAccessException("Id del procesor repetido");
        }
        database.put(process.getId(), process);
    }

    @Override
    public List<Process> readAll() throws DataAccessException {
        if (database.values() == null) {
            throw new DataAccessException("");
        }
        return new ArrayList<>(database.values());
    }

    @Override
    public Process readById(Integer id) throws DataAccessException {
        Process process = database.get(id);
        if (process == null) {
            throw new DataAccessException("El proceso es null");
        }
        return process;
    }

    @Override
    public void updateById(Integer id, Process newData) throws DataAccessException {
        readById(id);
        database.put(id, newData);
    }

    @Override
    public void deleteById(Integer id) throws DataAccessException {
        readById(id);
        database.remove(id);
    }
}
