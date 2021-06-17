package app.repositories;

import app.database.FileManagement;
import app.database.FileManager;
import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.metadata.parts.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class SerializationProcessRepository implements ProcessRepository {

    private final FileManagement database;

    public SerializationProcessRepository(FileManagement database) {
        this.database = database;
    }

    public SerializationProcessRepository() {
        this(new FileManager("src/app/database/Process.obj"));
    }

    @Override
    public boolean contains(Long id) {
        try {
            return getById(id) != null;
        } catch (DataAccessException notFound) {
            return false;
        }
    }

    private ProcessRecord readRecords() throws DataAccessException {
        ProcessRecord record = (ProcessRecord) database.read();
        if (record == null || record.isInvalid()) {
            throw new DataAccessException("No existen procesos registrados");
        }
        return record;
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
        if (this.contains(process.getId())) {
            throw new DataAccessException("Id del proceso está repetido.");
        }

        ProcessRecord processRecord = this.readRecords().add(process);
        database.save(processRecord);
    }

    @Override
    public List<Process> getAll() throws DataAccessException {
        return readRecords().asList();
    }

    @Override
    public Process getById(Long id) throws DataAccessException {
        Process process = readRecords().getById(id);
        if (process == null) {
            throw new DataAccessException("Proceso no encontrado");
        }
        return process;
    }

    private <T> void mutateRecords(RecordMutator<T> mutator, T newData)
        throws DataAccessException {
        ProcessRecord processRecord = this.readRecords();
        mutator.mutate(processRecord, newData);
        database.save(processRecord);
    }

    @Override
    public void updateById(Long id, Process newData) throws DataAccessException {
        mutateRecords((record, updatedProcess) -> record.update(id, newData), newData);
    }

    @Override
    public void deleteById(Long id) throws DataAccessException {
        mutateRecords(ProcessRecord::remove, id);
    }

    private boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    private List<Process> getProcessesByTrial(
        String name,
        Function<Process, List<Person>> getTrialMethod
    ) throws DataAccessException {
        if (name == null) {
            throw new DataAccessException("El nombre del demandado es inválido");
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

    @FunctionalInterface
    public interface RecordMutator<T> {
        void mutate(ProcessRecord process, T updatedData);
    }

    private static class ProcessRecord implements Serializable {

        private Map<Long, Process> value;

        boolean isInvalid() {
            return this.value == null;
        }

        ProcessRecord add(Process process) {
            this.value.put(process.getId(), process);
            return this;
        }

        void update(Long id, Process process) {
            if (this.value.containsKey(id)) {
                this.value.put(process.getId(), process);
            }
        }

        Process getById(Long id) {
            return this.value.get(id);
        }

        void remove(Long id) {
            if (getById(id) != null) {
                this.value.remove(id);
            }
        }

        List<Process> asList() {
            return new ArrayList<>(this.value.values());
        }
    }
}
