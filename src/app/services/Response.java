package app.services;

import lombok.Data;

@Data
public class Response<T> {

    protected boolean error;
    private T data;

    public Response(T data) {
        this.data = data;
        this.error = false;
    }

    public Response() {
        this.error = true;
    }
}
