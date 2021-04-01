package app.controllers.document.types;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class DocType {

    private final List<String> types;

    public DocType() {
        this.types = new ArrayList<>();
    }
}
