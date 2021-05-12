package app.models.metadata.parts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Abstract entity of a person.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person implements Serializable {

    private String name;
    private String id;
    private IdType idType;

    public abstract String getFullName();
}
