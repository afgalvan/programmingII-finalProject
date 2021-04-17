package app.models.proceedings;

import java.time.LocalDate;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class ProceedingsDate {

    private LocalDate creationDate;
    private LocalDate incorporationDate;
}
