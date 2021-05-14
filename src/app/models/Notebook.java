package app.models;

import app.models.documents.Document;
import app.models.documents.DocumentDate;
import app.models.documents.DocumentExtraData;
import app.models.documents.DocumentPage;
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
    private final List<Document> documentList = new ArrayList<>();

    /**
     * Add a document metadata to a document metadata list.
     * @param name name of the document.
     * @param docOrder
     * @param dates
     * @param documentPage
     * @param documentExtraData
     */
    public void addDocument(
        String name,
        int docOrder,
        DocumentDate dates,
        DocumentPage documentPage,
        DocumentExtraData documentExtraData
    ) {
        this.documentList.add(
                new Document(name, docOrder, dates, documentPage, documentExtraData)
            );
    }
}
