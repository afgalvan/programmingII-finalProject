package app.models.metadata.parts;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Make reference to natural person.
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class NaturalPerson extends Person implements Serializable {

    private String lastName;

    public NaturalPerson(String name, String lastName, Integer id, IdType idType) {
        super(name, id, idType);
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", this.getName(), lastName);
    }
}
