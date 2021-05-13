package app.models.documents;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the information that takes part in the file.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Serializable {

    private String name;
    private Integer docOrder;
    private DocumentDate dates;
    private DocumentPage pages;
    private DocumentExtraData extraData;

    public List<String> getAsRow() {
        return Arrays.asList(
            name,
            dates.getCreationDate().toString(),
            dates.getIncorporationDate().toString(),
            docOrder.toString(),
            pages.getPagesAmount().toString(),
            pages.getInitPage().toString(),
            pages.getLastPage().toString(),
            extraData.getFileType(),
            extraData.getOrigin(),
            extraData.getSize().toString(),
            extraData.getObservations()
        );
    }
}
