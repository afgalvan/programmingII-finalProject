package app.models.records;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ValueObject
public class Location {
    private String department;
    private String city;
}
