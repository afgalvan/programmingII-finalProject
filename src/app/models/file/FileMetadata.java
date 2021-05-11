package app.models.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the information that takes part in the file.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileMetadata {

    private String name;
    private int docOrder;
    private FileDate dates;
    private FilePageData pageData;
    private FileExtraData extraData;
}
