package app.models.proceedings;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProceedingsDate {

    private LocalDate creationDate;
    private LocalDate incorporationDate;
}
