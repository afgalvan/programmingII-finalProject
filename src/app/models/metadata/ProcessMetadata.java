package app.models.metadata;

import app.models.metadata.parts.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the general information of the electronic process.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessMetadata implements Serializable {

    private Long id;
    private Location location;
    private JudicialOffice judicialOffice;
    private Series series;
    private final List<Person> judgedList = new ArrayList<>();
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
    public void addJudged(Person person) {
        judgedList.add(person);
    }

    public List<String> getAsRow() {
        return Arrays.asList(
            (location != null) ? location.getCity() : "",
            (judicialOffice != null) ? judicialOffice.getName() : "",
            (series != null) ? series.getName() : "",
            (id != null) ? id.toString() : "",
            judgedList.toString(),
            prosecutorList.toString()
        );
    }
}
