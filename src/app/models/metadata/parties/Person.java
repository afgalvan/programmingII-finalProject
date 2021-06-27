package app.models.metadata.parties;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract entity of a person.
 */
@Getter
@Setter
public abstract class Person extends TrialParty implements Serializable {

    private Integer id;
    private IdType idType;

    public Person(String name, Integer id, IdType idType) {
        super(name);
        this.id = id;
        this.idType = idType;
    }
}
