package app.models.records.parts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que modela de manera abstracta a una persona.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private String name;
    private String id;
    private IdTypes idType;

    public abstract String getFullName();
}
