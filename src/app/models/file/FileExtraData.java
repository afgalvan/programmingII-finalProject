package app.models.file;

import app.models.annotations.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Indicates the type, size and origin of the file and its observations.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class FileExtraData implements Serializable {

    private String fileType;
    private Double size;
    private String origin;
    private String observations;
}
