package app.models.metadata.parts;

import java.io.Serializable;

/**
 * Make reference to state entities.
 */

public class StateEntity extends Person implements Serializable {

    public StateEntity(String name) {
        this.setName(name);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }
}
