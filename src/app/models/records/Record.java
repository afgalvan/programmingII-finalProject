package app.models;

import java.util.List;

public interface Record<T, K> {
    Record<T, K> add(T process);

    boolean update(K id, T process);

    T getById(K id);

    List<T> asList();

    boolean remove(K id);

    boolean isEmpty();
}
