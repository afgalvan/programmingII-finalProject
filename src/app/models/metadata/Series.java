package app.models.metadata;

import java.io.Serializable;
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
 public class Series implements Serializable {

    private String name;
    private int code;
    private final List<SubSeries> subSeriesList = new ArrayList<>();

    /**
     * Add a sub series to a series.
     * @param name name of the sub series.
     * @param code code of the sub series.
     * @param docType Document type of the sub series.
     */
    public void addSubSeries(String name, int code, List<DocumentType> docType) {
        SubSeries subSeries = new SubSeries(name, code, docType);
        subSeriesList.add(subSeries);
    }
}
