package app.models.metadata.parties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Abstract entity of a person.
 */

@Data
@AllArgsConstructor
public abstract class TrialParty implements Serializable {

    private String name;

    public abstract String getFullName();

    public String toString() {
        return getFullName();
    }

    public abstract boolean hasInvalidData();
}
