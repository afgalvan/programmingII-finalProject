package app.models.metadata;

import app.models.annotations.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
