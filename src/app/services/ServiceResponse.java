package app.services;

import lombok.Data;

/**
 *
 * @param <T>
 */
@Data
public class ServiceResponse<T> {

    private boolean error;
    private T data;
    private String message;

    /**
     *
     * @param data
     */
    public ServiceResponse(T data) {
        this.data = data;
        this.error = false;
    }

    public ServiceResponse(String message) {
        this.error = true;
        this.message = message;
    }

    public ServiceResponse(String message, boolean error) {
        this.error = error;
        this.message = message;
    }

    public ServiceResponse() {
        this.error = true;
    }
}
