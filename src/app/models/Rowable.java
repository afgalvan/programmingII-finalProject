package app.models;

import app.models.annotations.TestedOn;
import java.util.List;
import test.models.RowableTest;

@TestedOn(RowableTest.class)
public interface Rowable {
    List<String> getAsRow();
}
