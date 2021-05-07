package app.models.proceedings;

import app.models.ValueObject;
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
public class ProceedingsPageData {

    private int pagesAmount;
    private int initPage;
    private int lastPage;
}
