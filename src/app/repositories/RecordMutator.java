package app.repositories;

import app.models.records.Record;

@FunctionalInterface
public interface RecordMutator<T extends Record, N> extends FunctionalMutator<T, N> {}
