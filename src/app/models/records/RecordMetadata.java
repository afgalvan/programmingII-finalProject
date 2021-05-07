package app.models.records;

import app.models.records.parts.Person;
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
public class RecordMetadata {

    private Location location;
    private JudicialOffice judicialOffice;
    private Series series;
    private long processFilingNumber;
    private final List<Person> judgePartyList = new ArrayList<>();
    private final List<Person> prosecutorList = new ArrayList<>();
    private Boolean hasPhysicalFile;
    private int foldersAmount;

    /**
     * Agrega al demandante al metadato de la actuacion.
     * @param person
     */
    public void addProsecutor(Person person) {
        prosecutorList.add(person);
    }

    /**
     * Agrega al demandado al metadato de la actuacion.
     * @param person
     */
    public void addJudgeParty(Person person) {
        judgePartyList.add(person);
    }
}
