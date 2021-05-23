package app.view;

import app.controllers.TableController;
import app.exceptions.RowsOutOfBoundsException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class TableBuilder<T> {

    private List<String> headers;
    private int columns;
    private final List<List<String>> body;
    private List<Integer> columnsWidth;
    private int width;
    private final TableController tableController;
    private final Box box;

    public TableBuilder(List<String> headers) {
        this.headers = headers;
        this.columns = headers.size();
        this.body = new ArrayList<>();
        this.body.add(headers);
        this.tableController = TableController.getInstance();
        this.box = new Box();
        if (body.size() != 0) {
            computeDimensions();
        }
    }

    public TableBuilder() {
        this(new ArrayList<>());
    }

    public void setHeaders(List<String> headers) {
        this.headers.clear();
        this.headers.addAll(headers);
        computeDimensions();
    }

    @SneakyThrows
    public void addRow(List<T> newRow) {
        if (newRow.size() != headers.size()) {
            throw new RowsOutOfBoundsException(
                "The row has different column len (" +
                newRow.size() +
                ") that it should (" +
                headers.size() +
                ")."
            );
        }

        List<String> stringRow = newRow
            .stream()
            .map(Object::toString)
            .collect(Collectors.toList());
        this.body.add(stringRow);
        computeDimensions();
    }

    public void computeDimensions() {
        this.columnsWidth = tableController.computeColumnsWidth(body);
        this.width = tableController.computeTableWidth(columnsWidth);
    }

    public void display() {
        displayBody();
    }

    private void displayBody() {
        box.horizontalRule(this.width);
        body.forEach(
            row -> {
                System.out.print("| ");
                for (int i = 0; i < row.size(); i++) {
                    int space = this.columnsWidth.get(i) - row.get(i).length();
                    System.out.print(
                        row.get(i) + TableController.voidSpaceOf(space) + " | "
                    );
                }
                System.out.println();
                box.horizontalRule(this.width);
            }
        );
    }
}
