package app.models.proceedings;

import app.models.ValueObject;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describe la fecha de creacion y la fecha de incorporacion
 * de un expediente.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class ProceedingsDate {

    private LocalDate creationDate;
    private LocalDate incorporationDate;
}
