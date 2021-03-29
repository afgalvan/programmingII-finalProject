package app.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private RecordMetadata recordMetadata;
    private int noteBooksLen;
    private final List<NoteBook> noteBooksList = new ArrayList<>(noteBooksLen);

    public void addNoteBook(String name) {
        this.noteBooksList.add(new NoteBook(name));
    }

    public void settleRecordMetadata(
        String department,
        String city,
        JudicialOffice judicialOffice,
        Series series,
        long processFilingNumber,
        Boolean hasPhysicalFile,
        int notebookAmount
    ) {
        this.recordMetadata =
            new RecordMetadata(
                department,
                city,
                judicialOffice,
                series,
                processFilingNumber,
                hasPhysicalFile,
                notebookAmount
            );
    }
}
