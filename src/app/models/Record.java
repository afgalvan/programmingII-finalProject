package app.models;

import java.util.List;

public interface Record {
    Record add(Process process);

    List<Process> asList();

    boolean isEmpty();
}
