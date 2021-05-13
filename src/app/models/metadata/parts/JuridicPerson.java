package app.models.metadata.parts;

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
}
