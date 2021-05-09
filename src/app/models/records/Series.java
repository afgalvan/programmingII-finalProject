package app.models.records;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates the name and code of the process to be executed.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Series {

    private String name;
    private int code;
    private final List<SubSeries> subSeriesList = new ArrayList<>();

    /**
     * Add a subserie to a serie.
     * @param name name of the subserie.
     * @param code code of the subserie.
     * @param docType Document type of the subserie.
     */
    public void addSubSeries(String name, int code, List<String> docType) {
        SubSeries subSeries = new SubSeries(name, code, docType);
        subSeriesList.add(subSeries);
    }
}
