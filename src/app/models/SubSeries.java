package app.models;

import app.models.document.types.DocType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubSeries {

    private String name;
    private int code;
    private DocType docType;
}
