package app.models.metadata;

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

    private int code;
    private String name;
}
