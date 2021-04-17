package app.models.proceedings;

import app.models.ValueObject;
import java.time.LocalDate;
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
