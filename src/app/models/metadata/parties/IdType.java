package app.models.metadata.parties;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * Enum that contains the id types of a person.
 */

@Getter
public enum IdType implements Serializable {
    NIT("NIT"),
    CC("Cédula ciudadana"),
    TI("Tarjeta de identidad"),
    PASSPORT("Pasaporte");

    private final String type;

    IdType(String _type) {
        this.type = _type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static List<String> getAll() {
        return Arrays
            .stream(IdType.values())
            .map(IdType::getType)
            .collect(Collectors.toList());
    }
}
