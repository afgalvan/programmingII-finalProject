package app.models.metadata;

import app.models.Rowable;
import app.models.metadata.parts.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the general information of the electronic process.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessMetadata implements Serializable, Rowable {

    private Long id;
    private Location location;
    private JudicialOffice judicialOffice;
    private Series series;
    private final List<Person> judgedList = new ArrayList<>();
    private final List<Person> prosecutorList = new ArrayList<>();
    private PhysicalInformation physicalInformation;

    public ProcessMetadata(Long id) {
        this.id = id;
    }

    /**
     * Add a prosecutor to the prosecutorList of the metadata.
     *
     * @param person the prosecutor of the process.
     */
    public void addProsecutor(Person person) {
        prosecutorList.add(person);
    }

    /**
     * Add a judge party to the judgePartyList of the metadata.
     *
     * @param person the judge party in the process.
     */
    public void addJudged(Person person) {
        judgedList.add(person);
    }

    @Override
    public List<String> getAsRow() {
        return Arrays.asList(
            safeToString(location, Location::getCity),
            safeToString(judicialOffice, JudicialOffice::getName),
            safeToString(series, Series::getName),
            safeToString(id, Objects::toString),
            safeToString(judgedList, Objects::toString),
            safeToString(prosecutorList, Objects::toString)
        );
    }
}
