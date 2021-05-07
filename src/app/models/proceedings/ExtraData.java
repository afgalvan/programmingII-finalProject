package app.models.proceedings;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indica el tipo de archivo, el tamaño del archivo,
 * el origen del documento y las observaciones en el expediente.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class ExtraData {

    private String fileType;
    private double size;
    private String origin;
    private String observations;
}
