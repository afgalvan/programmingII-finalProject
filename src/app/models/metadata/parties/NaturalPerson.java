package app.models.metadata.parties;

import java.io.Serializable;
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

    @Override
    public boolean hasInvalidData() {
        return (
            this.getName() == null ||
            this.getName().isEmpty() ||
            this.getId() == null ||
            this.getIdType() == null ||
            this.lastName == null ||
            this.lastName.isEmpty()
        );
    }
}
