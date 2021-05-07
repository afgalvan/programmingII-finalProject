package app.models.records;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indica el departamento y ciudad donde se inició el trámite del proceso.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ValueObject
public class Location {

    private String department;
    private String city;
}
