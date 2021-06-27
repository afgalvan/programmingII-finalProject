package app.models.metadata.parties;

import java.io.Serializable;

/**
 * Make reference to state entities.
 */
public class StateEntity extends TrialParty implements Serializable {

    public StateEntity(String name) {
        super(name);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }

    @Override
    public boolean hasInvalidData() {
        return this.getName() == null || this.getName().isEmpty();
    }
}
