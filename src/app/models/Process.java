package app.models;

import app.models.metadata.*;
import java.io.Serializable;
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
public class Process implements Serializable {

    private ProcessMetadata metadata;
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
     * @param id
     * @param physicalInformation
     */
    public void setMetadata(
        Long id,
        Location location,
        JudicialOffice judicialOffice,
        Series series,
        PhysicalInformation physicalInformation
    ) {
        this.metadata =
            new ProcessMetadata(
                id,
                location,
                judicialOffice,
                series,
                physicalInformation
            );
    }

    public Notebook getNotebookByName(String name) {
        return notebooksList
            .stream()
            .filter(notebook -> notebook.getName().equals(name))
            .findFirst()
            .orElse(null);
    }
}
