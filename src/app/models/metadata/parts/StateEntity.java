package app.models.metadata.parts;

/**
 * Make reference to state entities.
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
