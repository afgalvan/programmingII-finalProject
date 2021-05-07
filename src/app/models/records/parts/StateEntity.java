package app.models.records.parts;

/**
 * Hace referencia a aquellas entidades que pertenecen al estado.
 */

public class StateEntity extends Person {

    public StateEntity(String name) {
        this.setName(name);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }
}
