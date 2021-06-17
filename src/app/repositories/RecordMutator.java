package app.repositories;

import app.models.Record;

@FunctionalInterface
public interface RecordMutator<T extends Record, N> extends FunctionalMutator<T, N> {}
