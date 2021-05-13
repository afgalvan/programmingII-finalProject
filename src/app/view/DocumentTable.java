package app.view;

import app.models.Process;

import java.util.Arrays;
import java.util.List;

public class DocumentTable extends MetadataTable {

    public DocumentTable(Displayable last, Process process) {
        super(last, process);
    }

    @Override
    public void fillTable() {
        super
            .getProcess()
            .getNotebooksList()
            .forEach(
                notebook ->
                    notebook
                        .getFilesList()
                        .forEach(file -> super.getBuilder().addRow(file.getAsRow()))
            );
    }

    public void addRow(List<String> row) {
        super.getBuilder().addRow(row);
    }

    @Override
    public void initTable() {
        // prettier-ignore-start
        List<String> headers = Arrays.asList(
            "Nombre", "Fecha de creacion", "Fecha incorporación",
            "Orden", "Paginas", "Inicio", "Fin", "Formato", "Origen",
            "Tamaño", "Observaciones"
        );
        // prettier-ignore-end
        super.setBuilder(new TableBuilder<>(headers));
    }
}
