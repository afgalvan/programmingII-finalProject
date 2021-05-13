package app.models.metadata;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the name and code of the sub series that is going to be processed.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubSeries implements Serializable {

    private String name;
    private int code;
    private List<DocumentType> docType;
}
