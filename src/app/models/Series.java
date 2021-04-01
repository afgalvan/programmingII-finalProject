package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Series {

    private String name;
    private int code;
    private final List<SubSeries> subSeriesList = new ArrayList<>();

    public void addSubSeries(String name, int code, List<String> docType) {
        SubSeries subSeries = new SubSeries(name, code, docType);
        subSeriesList.add(subSeries);
    }
}
