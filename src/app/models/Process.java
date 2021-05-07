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
 * Hace referencia a todo proceso judicial a ser digitalizado.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private RecordMetadata recordMetadata;
    private int noteBooksLen;
    private final List<Notebook> notebooksList = new ArrayList<>(noteBooksLen);

    /**
     * Permite agregar un cuaderno a la lista de cuadernos a partir de un nombre.
     * @param name
     */
    public void addNoteBook(String name) {
        this.notebooksList.add(new Notebook(name));
    }

    /**
     * Permite instanciar un expediente a partir de los parametros recibidos.
     * @param location
     * @param judicialOffice
     * @param series
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
