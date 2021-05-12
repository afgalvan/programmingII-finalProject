package app.models.metadata;

import app.models.annotations.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Indicate the department and city where the process begin.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ValueObject
public class Location implements Serializable {

    private String department;
    private String city;
}
