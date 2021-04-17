package app.models.proceedings;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
