package app.models.documents;

import app.models.Rowable;
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
public class Document implements Serializable, Rowable {

    private String name;
    private Integer docOrder;
    private DocumentDate dates;
    private DocumentPage pages;
    private DocumentExtraData extraData;

    @Override
    public List<String> getAsRow() {
        return Arrays.asList(
            name,
            dates != null ? dates.getCreationDate().toString() : "",
            dates != null ? dates.getIncorporationDate().toString() : "",
            docOrder != null ? docOrder.toString() : "",
            pages != null ? pages.getPagesAmount().toString() : "",
            pages != null ? pages.getInitPage().toString() : "",
            pages != null ? pages.getLastPage().toString() : "",
            extraData != null ? extraData.getFileType() : "",
            extraData != null ? extraData.getOrigin() : "",
            extraData != null ? extraData.getSize().toString() : "",
            extraData != null ? extraData.getObservations() : ""
        );
    }
}
