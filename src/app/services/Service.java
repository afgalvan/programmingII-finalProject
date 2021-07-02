package app.services;

import app.models.Response;
import java.util.List;

/**
 * @param <K> Data Key.
 * @param <T> Data Type.
 */
public interface Service<T, K> {
    Response<T> insert(T data);

    Response<List<T>> getAll();

    Response<T> getById(K id);

    Response<T> updateById(K id, T newData);

    Response<T> deleteById(K id);
}
