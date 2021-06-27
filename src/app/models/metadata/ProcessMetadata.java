package app.models.metadata;

import app.models.Rowable;
import app.models.metadata.parties.TrialParty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private final List<TrialParty> judgedList = new ArrayList<>();
    private final List<TrialParty> prosecutorList = new ArrayList<>();
    private PhysicalInformation physicalInformation;

    public ProcessMetadata(Long id) {
        this.id = id;
    }

    /**
     * Add a prosecutor to the prosecutorList of the metadata.
     *
     * @param trialParty the prosecutor of the process.
     */
    public void addProsecutor(TrialParty trialParty) {
        prosecutorList.add(trialParty);
    }

    /**
     * Add a judge party to the judgePartyList of the metadata.
     *
     * @param trialParty the judge party in the process.
     */
    public void addJudged(TrialParty trialParty) {
        judgedList.add(trialParty);
    }

    @Override
    public List<String> getAsRow() {
        return Arrays.asList(
            safeToString(location, Location::getCity),
            safeToString(judicialOffice, JudicialOffice::getName),
            safeToString(series, Series::getName),
            safeToString(id, Object::toString),
            safeToString(judgedList, Object::toString),
            safeToString(prosecutorList, Object::toString)
        );
    }
}
