package app.models;

import app.models.documents.Document;
import app.models.documents.DocumentDate;
import app.models.documents.DocumentExtraData;
import app.models.documents.DocumentPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private List<Document> documentList = new ArrayList<>();

    public Notebook(String name) {
        this.name = name;
    }

    /**
     * Add a document metadata to a document list.
     *
     * @param name              name of the document.
     * @param docOrder          the insertion order of the document on the current notebook.
     * @param dates             the dates of the document.
     * @param documentPage      the page information of the document.
     * @param documentExtraData additional information of the document.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return name.equals(notebook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
