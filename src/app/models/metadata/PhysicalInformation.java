package app.models.metadata;

import app.models.annotations.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ValueObject
@Data
public class PhysicalInformation {

    private Boolean hasPhysicalFile;
    private int foldersAmount;
}
