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
    private JudicialOffice judicialOffice;
    private Series series;
    private long processFilingNumber;
    private final List<Person> judgePartyList = new ArrayList<>();
    private final List<Person> prosecutorList = new ArrayList<>();
    private Boolean hasPhysicalFile;
    private int foldersAmount;

    public void addProsecutor(Person person) {
        prosecutorList.add(person);
    }

    public void addJudgeParty(Person person) {
        judgePartyList.add(person);
    }
}
