package app.models.documents;

import app.models.annotations.ValueObject;
import java.io.Serializable;
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
public class DocumentExtraData implements Serializable {

    private String fileType;
    private Double size;
    private String origin;
    private String observations;
}
