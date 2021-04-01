package app.services;

public interface Service<T> {
    public Response<T> create(T data);

    public Response read(T data);

    public boolean update(T data);

    public boolean delete(T data);
}
