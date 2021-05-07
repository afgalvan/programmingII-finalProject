package app.models.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indica el nombre y codigo de un documento.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentType {

    private String name;
    private int code;
}
