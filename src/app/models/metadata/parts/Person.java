package app.models.metadata.parts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abstract entity of a person.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private String name;
    private String id;
    private IdType idType;

    public abstract String getFullName();
}