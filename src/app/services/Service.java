package app.services;

import java.util.List;

public interface Service<T, K> {
    public ServiceResponse<T> create(T data);

    public ServiceResponse<List<T>> readAll();

    public ServiceResponse<T> read(K id);

    public ServiceResponse<T> update(K id, T newData);

    public ServiceResponse<T> delete(K id);
}
