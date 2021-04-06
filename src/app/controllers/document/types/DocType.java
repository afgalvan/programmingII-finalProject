package app.controllers.document.types;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * An abstract class to get the document types from the retention table.
 */
@Getter
public abstract class DocType {

    private final List<String> types;

    public DocType() {
        this.types = new ArrayList<>();
    }
}
