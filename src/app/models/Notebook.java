package app.models;

import app.models.file.FileDate;
import app.models.file.FileExtraData;
import app.models.file.FileMetadata;
import app.models.file.FilePageData;
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
    private final List<FileMetadata> fileMetadataList = new ArrayList<>();

    /**
     * Add a document metadata to a document metadata list.
     * @param name name of the document.
     * @param docOrder
     * @param dates
     * @param filePageData
     * @param fileExtraData
     */
    public void addProceedingsMetadata(
        String name,
        int docOrder,
        FileDate dates,
        FilePageData filePageData,
        FileExtraData fileExtraData
    ) {
        this.fileMetadataList.add(
                new FileMetadata(name, docOrder, dates, filePageData, fileExtraData)
            );
    }
}
