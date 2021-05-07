package app.models.records.parts;

import lombok.Getter;

/**
 * Enumeración que contiene los tipos de identificación para una persona.
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
