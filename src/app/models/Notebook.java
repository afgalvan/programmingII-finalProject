package app.models;

import app.models.file.File;
import app.models.file.FileDate;
import app.models.file.FileExtraData;
import app.models.file.FilePage;

import java.io.Serializable;
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
public class Notebook implements Serializable {

    private String name;
    private final List<File> filesList = new ArrayList<>();

    /**
     * Add a document metadata to a document metadata list.
     * @param name name of the document.
     * @param docOrder
     * @param dates
     * @param filePage
     * @param fileExtraData
     */
    public void addFile(
        String name,
        int docOrder,
        FileDate dates,
        FilePage filePage,
        FileExtraData fileExtraData
    ) {
        this.filesList.add(new File(name, docOrder, dates, filePage, fileExtraData));
    }
}
