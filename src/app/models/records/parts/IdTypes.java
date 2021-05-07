package app.models.records.parts;

import lombok.Getter;

/**
 * Enum that contains the id types of a person.
 */

@Getter
public enum IdTypes {
    NIT("NIT"),
    CC("Cédula ciudadana"),
    TI("Tarjeta de identidad"),
    PASSPORT("Pasaporte");

    private final String type;

    IdTypes(String _type) {
        this.type = _type;
    }
}
