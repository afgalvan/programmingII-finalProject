package app.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DialogResponse<T> {

    public static final int ERROR_MESSAGE = 0;
    public static final int INFORMATION_MESSAGE = 1;
    public static final int WARNING_MESSAGE = 2;
    public static final int QUESTION_MESSAGE = 3;
    public static final int PLAIN_MESSAGE = -1;

    private String title;
    private String message;
    private int type;
    private T data;

    /**
     *
     * @param title
     * @param message
     * @param type
     */
    public DialogResponse(String title, String message, int type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }
}
