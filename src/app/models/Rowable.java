package app.models;

import app.models.annotations.Testable;
import java.util.List;
import test.models.RowableTest;

@Testable(testClass = RowableTest.class)
public interface Rowable {
    List<String> getAsRow();
}
