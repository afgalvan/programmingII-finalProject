package app.repositories;

import app.models.ProcessRecord;

@FunctionalInterface
public interface ProcessRecordMutator<T> extends RecordMutator<ProcessRecord, T> {}
