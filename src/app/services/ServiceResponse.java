package app.services;

import lombok.Data;

@Data
public class ServiceResponse<T> {

    private boolean error;
    private T data;
    private String message;

    public ServiceResponse(T data) {
        this.data = data;
        this.error = false;
    }

    public ServiceResponse(String message) {
        this.error = false;
        this.message = message;
    }

    public ServiceResponse() {
        this.error = true;
    }
}
