package app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcessRecord implements Serializable, Record<Process, Long> {

    private final Map<Long, Process> value;

    public ProcessRecord() {
        this.value = new LinkedHashMap<>();
    }

    @Override
    public ProcessRecord add(Process process) {
        this.value.put(process.getId(), process);
        return this;
    }

    @Override
    public boolean update(Long id, Process process) {
        if (this.value.containsKey(id)) {
            this.value.put(process.getId(), process);
            return true;
        }

        return false;
    }

    @Override
    public Process getById(Long id) {
        return this.value.get(id);
    }

    @Override
    public boolean remove(Long id) {
        if (getById(id) != null) {
            this.value.remove(id);
            return true;
        }

        return false;
    }

    @Override
    public List<Process> asList() {
        return new ArrayList<>(this.value.values());
    }

    @Override
    public boolean isEmpty() {
        return this.value.isEmpty();
    }
}
