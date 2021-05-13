package app.view;

import app.models.Process;
import lombok.Data;

@Data
public abstract class MetadataTable implements Table {

    private TableBuilder<String> builder;
    private final Displayable last;
    private final Process process;

    public MetadataTable(Displayable last, Process process) {
        this.last = last;
        this.process = process;
    }

    public void display(boolean cleanAndWait) {
        if (cleanAndWait) {
            View.clear();
        }
        initTable();
        fillTable();
        builder.display();
        if (cleanAndWait) {
            View.waitForEnter();
        }
        if (last != null) {
            last.display();
        }
    }

    public void display() {
        this.display(true);
    }
}
