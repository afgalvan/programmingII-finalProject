package app.view;

import app.models.Process;
import java.util.Arrays;
import java.util.List;

public class ProcessMetadataTable extends MetadataTable {

    public ProcessMetadataTable(Displayable last, Process process) {
        super(last, process);
    }

    @Override
    public void initTable() {
        // prettier-ignore-start
        List<String> headers = Arrays.asList(
            "Ciudad", "Despacho Judicial", "Serie", "No. Radicacion",
            "Parte A", "Parte B"
        );
        // prettier-ignore-end

        super.setBuilder(new TableBuilder<>(headers));
    }

    @Override
    public void fillTable() {
        super.getBuilder().addRow(super.getProcess().getMetadata().getAsRow());
    }
}
