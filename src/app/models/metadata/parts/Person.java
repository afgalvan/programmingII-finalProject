package app.models.metadata.parts;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abstract entity of a person.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person implements Serializable {

    private String name;
    private Integer id;
    private IdType idType;

    public abstract String getFullName();

    public String toString() {
        return getFullName();
    }
}
