package app.models.records.parts;

/**
 * Hacer referencia al tipo de persona jurídica.
 */

public class JuridicPerson extends Person {

    public JuridicPerson(String name, String id, IdTypes idType) {
        super(name, id, idType);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }
}
