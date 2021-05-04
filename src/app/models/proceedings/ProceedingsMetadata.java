package app.models.proceedings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
