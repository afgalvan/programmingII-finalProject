package app.models;

import app.models.annotations.TestedOn;
import java.util.List;
import java.util.function.Function;

import test.models.RowableTest;

@TestedOn(RowableTest.class)
public interface Rowable {
    List<String> getAsRow();

    default <T> String safeToString(T object, Function<T, String> function) {
        return object != null ? function.apply(object) : "";
    }

    default int size() {
        return getAsRow().size();
    }
}
