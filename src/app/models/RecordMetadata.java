package app.models;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordMetadata {

    private String department;
    private String city;
    private long processFilingNumber;
    private int notebookAmount;
    private Boolean hasPhysicalFile;
    private JudicialOffice judicialOffice;
    private Series serie;
    private final List<Person> prosecutorList = new ArrayList<>();
    private final List<Person> judgePartyList = new ArrayList<>();

    public void addProsecutor(Person person) {
        prosecutorList.add(person);
    }

    public void addJudgeParty(Person person) {
        judgePartyList.add(person);
    }
}
