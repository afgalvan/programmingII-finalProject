package app.models.file;

import app.models.annotations.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Indicates the number of pages in a file, and its
 * init and last page.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class FilePage implements Serializable {

    private Integer pagesAmount;
    private Integer initPage;
    private Integer lastPage;
}
