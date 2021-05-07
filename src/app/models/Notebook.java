package app.models;

import app.models.proceedings.ProceedingsDate;
import app.models.proceedings.ProceedingsExtraData;
import app.models.proceedings.ProceedingsMetadata;
import app.models.proceedings.ProceedingsPageData;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of the notebooks that store the metadata of the actions.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notebook {

    private String name;
    private final List<ProceedingsMetadata> proceedingsMetadataList = new ArrayList<>();

    /**
     * Add a document metadata to a document metadata list.
     * @param name name of the document.
     * @param docOrder
     * @param dates
     * @param pageData
     * @param extraData
     */
    public void addProceedingsMetadata(
        String name,
        int docOrder,
        ProceedingsDate dates,
        ProceedingsPageData proceedginsPageData,
        ProceedingsExtraData proceedingsExtraData
    ) {
        this.proceedingsMetadataList.add(
                new ProceedingsMetadata(
                    name,
                    docOrder,
                    dates,
                    proceedginsPageData,
                    proceedingsExtraData
                )
            );
    }
}
