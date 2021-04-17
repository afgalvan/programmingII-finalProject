package app.models.records.parts;

import lombok.Getter;

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
