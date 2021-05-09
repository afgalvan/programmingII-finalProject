package app.models.records.parts;

/**
 * Make reference to juridic person.
 */

public class JuridicPerson extends Person {

    public JuridicPerson(String name, String id, IdType idType) {
        super(name, id, idType);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }
}
