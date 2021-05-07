package app.models.records;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the name and code of the subserie that is going to be processed.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubSeries {

    private String name;
    private int code;
    private List<String> docType;
}
