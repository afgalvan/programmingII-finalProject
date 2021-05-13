package app.models.metadata;

import app.models.annotations.ValueObject;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@ValueObject
@Data
public class PhysicalInformation implements Serializable {

    private Boolean hasPhysicalFile;
    private Integer foldersAmount;
}
