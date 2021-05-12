package app.models.metadata;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the name and code of a file.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentType implements Serializable {

    private int code;
    private String name;
}
