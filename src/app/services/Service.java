package app.services;

import java.util.List;

/**
 *
 * @param <K> Data Key.
 * @param <T> Data Type.
 */
public interface Service<K, T> {
    ServiceResponse<T> insert(T data);

    ServiceResponse<List<T>> getAll();

    ServiceResponse<T> getById(K id);

    ServiceResponse<T> updateById(K id, T newData);

    ServiceResponse<T> deleteById(K id);
}
