package app.services;

import java.util.List;

public interface Service<P, T> {
    public Response<T> create(T data);

    public Response<List<T>> readAll();

    public Response<T> read(P id);

    public Response<T> update(P id, T newData);

    public Response<T> delete(P id);
}
