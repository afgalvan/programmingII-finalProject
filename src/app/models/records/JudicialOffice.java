package app.models.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudicialOffice {

    private String name;
    private int code;
    private String department;
    private String city;
    private String category;
}
