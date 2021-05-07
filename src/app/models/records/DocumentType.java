package app.models.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the name and code of a file.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentType {

    private String name;
    private int code;
}
