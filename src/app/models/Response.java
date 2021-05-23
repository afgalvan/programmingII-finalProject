package app.models;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @param <T> Generic of data type to return;
 */
@Getter
public class Response<T> {

    private final boolean error;
    private T data;

    @Setter
    private String message;

    public Response(T data) {
        this(data, "");
    }

    public Response(T data, String message) {
        this.error = false;
        this.data = data;
        this.message = message;
    }

    public Response(String message) {
        this.error = true;
        this.message = message;
    }

    public Response(String message, boolean error) {
        this.error = error;
        this.message = message;
    }

    public Response() {
        this.error = true;
    }
}
