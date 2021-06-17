package app.models;

import app.models.metadata.*;
import app.models.metadata.parts.Person;
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
    private List<Notebook> notebooksList = new ArrayList<>(noteBooksLen);

    public Process(ProcessMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Add a notebook to the notebook list from a name.
     * @param name name of the notebook.
     */
    public void addNoteBook(String name) {
        this.notebooksList.add(new Notebook(name));
    }

    /**
     * It allows to instantiate a file from the parameters received.
     * @param id A {@code Long} unique identifier for getting and reading the process.
     * @param location A {@code Location} that identifies the place where the process is being instantiated.
     * @param judicialOffice A {@code JudicialOffice} where the process is being executed.
     * @param series A {@code Series} of the record.
     * @param physicalInformation A {@code PhysicalInformation} that makes references of the process' physical information.
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

    public void setId(long id) {
        this.metadata.setId(id);
    }

    public Long getId() {
        return this.metadata.getId();
    }

    /**
     * Get a notebook of the current process given his name.
     * @param name The name of the name of the notebook to be got.
     *
     * @return A {@code Notebook} that matches the given name.
     */
    public Notebook getNotebookByName(String name) {
        int index = notebooksList.indexOf(new Notebook(name));
        if (index >= 0) {
            return notebooksList.get(index);
        }

        return null;
    }

    public List<Person> getProsecutorList() {
        return this.metadata.getProsecutorList();
    }

    public List<Person> getJudgedList() {
        return this.metadata.getJudgedList();
    }
}
