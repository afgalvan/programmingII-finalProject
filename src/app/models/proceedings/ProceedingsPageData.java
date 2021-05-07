package app.models.proceedings;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indica la cantidad de páginas de un expediente, así como su página inicial y la final.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class ProceedingsPageData {

    private int pagesAmount;
    private int initPage;
    private int lastPage;
}
