package app.services;

import lombok.Data;

@Data
public class Response<T> {

    private boolean error;
    private T data;
    private String message;

    public Response(T data) {
        this.data = data;
        this.error = false;
    }

    public Response(String message) {
        this.error = false;
        this.message = message;
    }

    public Response() {
        this.error = true;
    }
}
