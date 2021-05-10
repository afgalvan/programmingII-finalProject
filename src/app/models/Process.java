package app.models;

import app.models.records.JudicialOffice;
import app.models.records.Location;
import app.models.records.RecordMetadata;
import app.models.records.Series;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * It refers to any judicial process to be digitalized.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private int id;
    private RecordMetadata recordMetadata;
    private int noteBooksLen;
    private final List<Notebook> notebooksList = new ArrayList<>(noteBooksLen);

    /**
     * Add a notebook to the notebook list from a name.
     * @param name name of the notebook.
     */
    public void addNoteBook(String name) {
        this.notebooksList.add(new Notebook(name));
    }

    /**
     * It allows to instantiate a file from the parameters received.
     * @param location place where the process is being instantiated.
     * @param judicialOffice judicial office where the process is being executed.
     * @param series series of the record.
     * @param processFilingNumber
     * @param hasPhysicalFile
     * @param notebooksAmount
     */
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
