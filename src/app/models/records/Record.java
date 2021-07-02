package app.models.records;

import java.util.List;

public interface Record<T, K> {
    Record<T, K> add(T data);

    boolean update(K id, T data);

    T getById(K id);

    List<T> asList();

    boolean remove(K id);

    boolean isEmpty();
}
