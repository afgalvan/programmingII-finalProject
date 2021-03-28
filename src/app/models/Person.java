package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String id;
    private IdTypes idType;
}
