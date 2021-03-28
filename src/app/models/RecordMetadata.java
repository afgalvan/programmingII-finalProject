package app.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordMetadata{
    private String department;
    private String city;
    private int processFilingNumber;
    private int notebookAmount;
    private Boolean hasPhysicalFile;
    private JudicialOffice judicialOffice;
    private Serie serie;
    private List<Person> prosecutor;
    private List<Person> judgeParty;
}
