package app.models.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent the judicial office of the process.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudicialOffice {

    private String name;
    private int code;
    private Location location;
    private String category;
}
