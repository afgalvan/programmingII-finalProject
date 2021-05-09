package app.services;

import java.util.List;

/**
 *
 * @param <T>
 * @param <K>
 */
public interface Service<K, T> {
    public ServiceResponse<T> create(T data);

    public ServiceResponse<List<T>> readAll();

    public ServiceResponse<T> read(K id);

    public ServiceResponse<T> update(K id, T newData);

    public ServiceResponse<T> delete(K id);
}
