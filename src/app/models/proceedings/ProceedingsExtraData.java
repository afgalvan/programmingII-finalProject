package app.models.proceedings;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the type, size and origin of the file and its observations.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class ProceedingsExtraData {

    private String fileType;
    private double size;
    private String origin;
    private String observations;
}
