package app.models.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Represent the judicial office of the process.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudicialOffice implements Serializable {

    private String name;
    private int code;
    private Location location;
    private String category;
}
