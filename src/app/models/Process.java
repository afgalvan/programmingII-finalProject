package app.models;

import java.util.ArrayList;
import java.util.List;

import app.models.records.JudicialOffice;
import app.models.records.Location;
import app.models.records.RecordMetadata;
import app.models.records.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private RecordMetadata recordMetadata;
    private int noteBooksLen;
    private final List<Notebook> notebooksList = new ArrayList<>(noteBooksLen);

    public void addNoteBook(String name) {
        this.notebooksList.add(new Notebook(name));
    }

    public void setRecordMetadata(
        Location location,
        JudicialOffice judicialOffice,
        Series series,
        long processFilingNumber,
        Boolean hasPhysicalFile,
        int notebooksAmount
    ) {
        this.recordMetadata =
            new RecordMetadata(
                location,
                judicialOffice,
                series,
                processFilingNumber,
                hasPhysicalFile,
                notebooksAmount
            );
    }
}
