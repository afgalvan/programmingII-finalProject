package app.models.metadata;

import app.models.metadata.parts.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Hace referencia a la información general del expediente judicial electrónico.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessMetadata {

    private Long id;
    private Location location;
    private JudicialOffice judicialOffice;
    private Series series;
    private final List<Person> judgePartyList = new ArrayList<>();
    private final List<Person> prosecutorList = new ArrayList<>();
    private PhysicalInformation physicalInformation;

    /**
     * Add a prosecutor to the prosecutorList of the metadata.
     * @param person the prosecutor of the process.
     */
    public void addProsecutor(Person person) {
        prosecutorList.add(person);
    }

    /**
     * Add a judge party to the judgePartyList of the metadata.
     * @param person the judge party in the process.
     */
    public void addJudgeParty(Person person) {
        judgePartyList.add(person);
    }
}
