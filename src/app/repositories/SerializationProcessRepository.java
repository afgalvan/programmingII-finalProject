package app.repositories;

import app.database.FileManagement;
import app.database.FileManager;
import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.ProcessRecord;
import app.models.Record;
import app.models.metadata.parts.Person;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SerializationProcessRepository implements ProcessRepository {

    private final FileManagement database;

    public SerializationProcessRepository(FileManagement database) {
        this.database = database;
    }

    public SerializationProcessRepository() {
        this(new FileManager("Process.obj"));
    }

    @Override
    public boolean contains(Long id) {
        try {
            return getById(id) != null;
        } catch (DataAccessException notFound) {
            return false;
        }
    }

    private ProcessRecord defaultReadRecord() {
        ProcessRecord record = (ProcessRecord) database.read();
        return record == null ? new ProcessRecord() : record;
    }

    private ProcessRecord safeReadRecords() throws DataAccessException {
        ProcessRecord record = (ProcessRecord) database.read();
        if (record == null || record.isEmpty()) {
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

        Record processRecord = this.defaultReadRecord().add(process);
        database.save(processRecord);
    }

    @Override
    public List<Process> getAll() throws DataAccessException {
        return safeReadRecords().asList();
    }

    @Override
    public Process getById(Long id) throws DataAccessException {
        Process process = safeReadRecords().getById(id);
        if (process == null) {
            throw new DataAccessException("Ningún proceso con id " + id + " encontrado");
        }
        return process;
    }

    private <T> void mutateRecords(ProcessRecordMutator<T> mutator, T newData)
        throws DataAccessException {
        ProcessRecord processRecord = this.safeReadRecords();
        mutator.mutate(processRecord, newData);
        database.save(processRecord);
    }

    @Override
    public boolean updateById(Long id, Process newData) throws DataAccessException {
        getById(id);
        mutateRecords((record, updatedProcess) -> record.update(id, newData), newData);
        return true;
    }

    @Override
    public boolean deleteById(Long id) throws DataAccessException {
        getById(id);
        mutateRecords(ProcessRecord::remove, id);
        return true;
    }

    private boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    @FunctionalInterface
    private interface TrialGetter {
        List<Person> getTrials(Process process);
    }

    private List<Process> getProcessesByTrial(String searchedName, TrialGetter method)
        throws DataAccessException {
        if (searchedName == null) {
            throw new DataAccessException("El nombre del demandado es inválido");
        }

        // prettier-ignore-start
        Predicate<Process> search = process ->
            method.getTrials(process).stream()
                .map(Person::getFullName)
                .anyMatch(trialName -> containsIgnoreCase(trialName, searchedName)
                );
        // prettier-ignore-end

        List<Process> matchList = getAll().stream()
            .filter(search)
            .collect(Collectors.toList());

        if (matchList.isEmpty()) {
            throw new DataAccessException("Ningún proceso encontrado");
        }

        return matchList;
    }

    @Override
    public List<Process> getProcessesByJudged(String name) throws DataAccessException {
        TrialGetter getJudgedList = Process::getJudgedList;
        return getProcessesByTrial(name, getJudgedList);
    }

    @Override
    public List<Process> getProcessByProsecutor(String name) throws DataAccessException {
        TrialGetter getProsecutorList = Process::getProsecutorList;
        return getProcessesByTrial(name, getProsecutorList);
    }
}
