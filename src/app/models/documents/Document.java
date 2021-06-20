package app.models.documents;

import app.models.Rowable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
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
            safeToString(name, Object::toString),
            safeToString(dates, d -> d.getCreationDate().toString()),
            safeToString(dates, d -> d.getIncorporationDate().toString()),
            safeToString(docOrder, Object::toString),
            safeToString(pages, p -> p.getPagesAmount().toString()),
            safeToString(pages, p -> p.getInitPage().toString()),
            safeToString(pages, p -> p.getLastPage().toString()),
            safeToString(extraData, DocumentExtraData::getFileType),
            safeToString(extraData, DocumentExtraData::getOrigin),
            safeToString(extraData, e -> e.getSize().toString()),
            safeToString(extraData, DocumentExtraData::getObservations)
        );
    }
}
