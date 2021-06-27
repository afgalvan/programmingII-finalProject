package app.models.documents;

import app.models.annotations.ValueObject;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the number of pages in a file, and its
 * init and last page.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class DocumentPage implements Serializable {

    private Integer pagesAmount;
    private Integer initPage;
    private Integer lastPage;
}
