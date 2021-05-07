package app.models.proceedings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describe la información de los documentos que conforman el expediente.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProceedingsMetadata {

    private String name;
    private int docOrder;
    private ProceedingsDate dates;
    private PageData pageData;
    private ExtraData extraData;
}
