package app.services;

import java.util.List;

/**
 *
 * @param <K> Data Key.
 * @param <T> Data Type.
 */
public interface Service<K, T> {
    ServiceResponse<T> create(T data);

    ServiceResponse<List<T>> readAll();

    ServiceResponse<T> getById(K id);

    ServiceResponse<T> updateById(K id, T newData);

    ServiceResponse<T> deleteById(K id);
}
