package app.models.metadata.parties;

import java.io.Serializable;

/**
 * Make reference to juridic person.
 */

public class JuridicPerson extends Person implements Serializable {

    public JuridicPerson(String name, Integer id, IdType idType) {
        super(name, id, idType);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }

    @Override
    public boolean hasInvalidData() {
        return (
            this.getName() == null ||
            this.getName().isEmpty() ||
            this.getId() == null ||
            this.getIdType() == null
        );
    }
}
