package app.services;

public interface Service<T> {
    public Response<T> create(T data);

    public Response<T> read(T data);

    public Response<T> update(T original, T newData);

    public Response<T> delete(T data);
}
