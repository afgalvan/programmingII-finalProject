package app.controllers;

import app.models.Response;
import app.models.annotations.SideTest;
import lombok.Getter;
import lombok.Setter;

/**
 * A class to return data as response between controllers and views.
 *
 * @param <T> data type that the response should contain.
 */
@Getter
@Setter
@SideTest(UserController.class)
public class DialogResponse<T> extends Response<T> {

    public static final int PLAIN_MESSAGE = -1;
    public static final int ERROR_MESSAGE = 0;
    public static final int INFORMATION_MESSAGE = 1;
    public static final int WARNING_MESSAGE = 2;
    public static final int QUESTION_MESSAGE = 3;

    private String title;
    private int statusCode;

    public DialogResponse(String title, String message, int statusCode, T data) {
        this(title, message, statusCode);
        super.setData(data);
    }

    public DialogResponse(String title, String message, int statusCode) {
        super(message, statusCode == ERROR_MESSAGE);
        this.title = title;
        this.statusCode = statusCode;
    }

    public DialogResponse(String title, String message) {
        this(title, message, ERROR_MESSAGE);
    }
}
