package app.models.proceedings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the information that takes part in the file.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProceedingsMetadata {

    private String name;
    private int docOrder;
    private ProceedingsDate dates;
    private ProceedingsPageData pageData;
    private ProceedingsExtraData extraData;
}
