package app.services;

import app.models.User;

public interface Service<T> {
    public Response<T> create(T data);

    public Response<T> read(T data);

    public Response<User> update(T original, T newData);

    public Response<User> delete(T data);
}
