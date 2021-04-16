package app.services;

import java.util.List;

public interface Service<T, K> {
    public Response<T> create(T data);

    public Response<List<T>> readAll();

    public Response<T> read(K id);

    public Response<T> update(K id, T newData);

    public Response<T> delete(K id);
}
