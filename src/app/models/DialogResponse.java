package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DialogResponse {

    private String title;
    private String content;
    private int option;
}
