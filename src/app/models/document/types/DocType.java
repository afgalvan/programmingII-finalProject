package app.models.document.types;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public abstract class DocType {

    private final List<String> types;

    public DocType() {
        this.types = new ArrayList<>();
    }
}
