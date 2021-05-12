package app.models.metadata.parts;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Make reference to natural person.
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class NaturalPerson extends Person implements Serializable {

    private String secondName;
    private String lastName;
    private String secondLastName;

    public NaturalPerson(
        String name,
        String secondName,
        String lastName,
        String secondLastName,
        String id,
        IdType idType
    ) {
        super(name, id, idType);
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
    }

    @Override
    public String getFullName() {
        return String.format(
            "%s %s %s %s",
            this.getName(),
            secondName,
            lastName,
            secondLastName
        );
    }
}
