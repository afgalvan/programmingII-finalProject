package app.models.records;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indica el nombre y código de subserie del proceso que se realizará.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubSeries {

    private String name;
    private int code;
    private List<String> docType;
}
