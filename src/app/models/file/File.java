package app.models.file;

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
public class File implements Serializable {

    private String name;
    private Integer docOrder;
    private FileDate dates;
    private FilePage pages;
    private FileExtraData extraData;

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
